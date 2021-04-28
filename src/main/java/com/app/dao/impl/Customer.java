package com.app.dao.impl;

import com.app.Account;
import com.app.BusinessException;
import com.app.dao.CustomerDAO;
import com.app.dbutil.PostgreConnection;


import java.sql.*;

public class Customer implements CustomerDAO {
    Account account;
    Customer customer;


    @Override
    public Account createAccount(Account account) throws SQLException, BusinessException {
        Connection connection = PostgreConnection.getConnection();
        String sql = "INSERT INTO project0.customer\n" + "(\n custid, \"name\", username, password, accountnumber) \n" +
                "VALUES(?,?,?,?,?);\n";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, account.getCustId());
        preparedStatement.setString(2, account.getName());
        preparedStatement.setString(3, account.getUsername());
        preparedStatement.setString(4, account.getPassword());
        preparedStatement.setInt(5, account.getAccountNumber());
        int rowsUpdated = preparedStatement.executeUpdate(sql);

        if (rowsUpdated > 0) {
            System.out.println("you inserted 1 one row");
        } else throw new BusinessException("failure please try again");

        return account;
    }
}

  /*  @Override
    public Account createAccount(int custid, String name, String username, String password, int accountNumber) throws SQLException, BusinessException {
         custid = account.getCustId();
         name = account.getName();
         username = account.getUsername();
         password = account.getPassword();
         accountNumber = account.getAccountNumber();
        PreparedStatement pstmt = null;

        try {


    Connection connection = PostgreConnection.getConnection();


    String sql = "INSERT INTO project0.customer\n" + "(\n custid, \"name\", username, password, accountnumber) \n" +
            "VALUES(?,?,?,?,?);\n";
    PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    preparedStatement.setInt(1, custid);
    preparedStatement.setString(2, name);
    preparedStatement.setString(3, username);
    preparedStatement.setString(4, password);
    preparedStatement.setInt(5, accountNumber);
    int rowsUpdated = preparedStatement.executeUpdate(sql);

    if (rowsUpdated > 0) {
       // ResultSet resultSet = preparedStatement.getGeneratedKeys();

        System.out.println("you updated 1 row");
        } else {
            throw new BusinessException("Failure in registration.... Please try again");
        }


        }catch (SQLException e) {
            e.printStackTrace();

        } finally {

            pstmt.close();

        }


            return account;
        }
    }
*/
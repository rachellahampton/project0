package com.app.dao.impl;

import com.app.Account;
import com.app.BusinessException;
import com.app.dao.CustomerDAO;
import com.app.dbutil.PostgreConnection;

import java.sql.*;

public class Customer implements CustomerDAO {


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
        int c = preparedStatement.executeUpdate();

        if (c == 1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                account.setCustId(resultSet.getInt(1));

            } else {
                throw new BusinessException("Failure in registration.... Please try again");
            }
        }


            return account;
        }
    }

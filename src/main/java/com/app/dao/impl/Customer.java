package com.app.dao.impl;

import com.app.Account;
import com.app.BusinessException;
import com.app.dao.CustomerDAO;
import com.app.dbutil.PostgreConnection;


import java.sql.*;

public class Customer implements CustomerDAO {
    Account account;
    Customer customer;
    Connection connection = PostgreConnection.getConnection();
    //  List<Account> accountList = new ArrayList<>();
    boolean hasResults;
    String match1;
    String match2;

    @Override
    public Account createAccount(Account account) throws SQLException, BusinessException {
        //  connection = PostgreConnection.getConnection();
        String sql = "INSERT INTO project0.customer " + "(custid, name, username, password, accountnumber, balance)" +
                "VALUES(?,?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, account.getCustId());
        preparedStatement.setString(2, account.getName());
        preparedStatement.setString(3, account.getUsername());
        preparedStatement.setString(4, account.getPassword());
        preparedStatement.setLong(5, account.getAccountNumber());
        preparedStatement.setDouble(6, account.getBalance());
        //  ResultSet resultSet = preparedStatement.executeUpdate();
        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("you inserted 1 one row");
        } else throw new BusinessException("failure please try again");

        return account;
    }

    @Override
    public Account pullFromDatabase(Account account) throws SQLException, BusinessException {

        Connection connection = PostgreConnection.getConnection();
        String sql = "SELECT username, password " + "FROM Project0.Customer WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, account.getUsername());
       //preparedStatement.setString(2, account.getPassword());
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Query executed");

                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username is " + resultSet.getString("username"));
                System.out.println("Password is " + resultSet.getString("password"));
                String storedName = account.getUsername();
                String storedPassword = account.getPassword();
                if (storedName.equals(username) && storedPassword.equals(password)) {

                    //  return new Account(username,password);
                    System.out.println("Found username and password match");

                } else {
                    System.out.println("no match found");
                }

                // System.out.println("Username is " + resultSet.getString("username"));
                // System.out.println("Password is " + resultSet.getString("password"));

            }


            return account;
        }

    @Override
    public Account updateDatabase(Account account) throws SQLException, BusinessException {
        Connection connection = PostgreConnection.getConnection();
        String sql = "UPDATE Project0.Customer" + "SET balance = ? WHERE custid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, account.getBalance());
        preparedStatement.setLong(2, account.getCustId());
    //    ResultSet resultSet = preparedStatement.executeQuery();

        int c=preparedStatement.executeUpdate();
        if(c==1){
            System.out.println("the balance is set in the database");

        }else {
            throw new BusinessException("Failure in registration... Please retry.....");
        }
        return account;
    }

    @Override
    public Account checkBalance(Account account) throws SQLException, BusinessException {
        Connection connection = PostgreConnection.getConnection();
        String sql = "SELECT custid, name, accountnumber, balance FROM Project0.Customer ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, account.getCustId());
        preparedStatement.setString(2, account.getName());
        preparedStatement.setLong(3, account.getAccountNumber());
        preparedStatement.setDouble(4, account.getBalance());
        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("you retrieved 1 one row");
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
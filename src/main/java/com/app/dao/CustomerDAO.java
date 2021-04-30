package com.app.dao;

import com.app.Account;
import com.app.BusinessException;

import java.sql.SQLException;

public interface CustomerDAO {
    public Account createAccount(Account account) throws SQLException, BusinessException;
    public Account pullFromDatabase(Account account) throws SQLException, BusinessException;
    public Account updateDatabase(Account account) throws SQLException, BusinessException;
    public Account checkBalance(Account account) throws SQLException, BusinessException;
   // public Account createAccount(int custid, String name, String username, String password, int accountNumber) throws SQLException, BusinessException;
   // public Customer createCustomer(Customer customer)
}

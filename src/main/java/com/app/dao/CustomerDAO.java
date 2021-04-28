package com.app.dao;

import com.app.Account;
import com.app.BusinessException;

import java.sql.SQLException;

public interface CustomerDAO {
    public Account createAccount(Account account) throws SQLException, BusinessException;
   // public Account createAccount(int custid, String name, String username, String password, int accountNumber) throws SQLException, BusinessException;
}

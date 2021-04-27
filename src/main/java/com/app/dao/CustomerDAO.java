package com.app.dao;

import com.app.Account;
import com.app.BusinessException;

import java.sql.SQLException;

public interface CustomerDAO {
    public Account createAccount(Account account) throws SQLException, BusinessException;
}

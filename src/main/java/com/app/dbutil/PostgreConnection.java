package com.app.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnection {
    private PostgreConnection() {}
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/postgres";
            String username="postgres";
            String password="admin";
            connection= DriverManager.getConnection(url,username,password);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    }
    public static Connection getConnection(){
        return connection;
    }
}

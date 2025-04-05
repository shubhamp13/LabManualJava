package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn
{
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    public static Connection getConnection()
    {
        Connection conn = null;
        try
        {
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_company","root","root");
        }catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        return conn;
    }
}

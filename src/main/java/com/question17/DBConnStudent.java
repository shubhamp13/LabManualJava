package com.question17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnStudent
{
    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    private static  final  String DB_URL = "jdbc:mysql://localhost:3306/user_db";
    private static  final  String USER = "root";
    private static  final  String PASS = "root";

    public  static Connection getConnection()
    {
        try
        {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            return conn;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

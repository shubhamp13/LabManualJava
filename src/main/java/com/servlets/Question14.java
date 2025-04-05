package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/event1")
public class Question14 extends HttpServlet {
    static
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e) {

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = request.getParameter("name");
       String  std=request.getParameter("class");
       String gender=request.getParameter("gender");
       String activity=request.getParameter("activity");
        response.setContentType("text/html");
       PrintWriter out = response.getWriter();
        try
        {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/event","root","root");
            String query="insert into event(name,class,gender,activity) values(?,?,?,?)";
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,std);
            ps.setString(3,gender);
            ps.setString(4,activity);
            if(ps.executeUpdate()>0)
            {
                out.println("<h1>User Added</h1>");
            }
            else
            {
                out.println("<h1>User Not Added</h1>");
            }
        }
        catch (SQLException e)
        {
          out.println(e.getLocalizedMessage());
        }

    }
}

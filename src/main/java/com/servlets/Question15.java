package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/bank")
public class Question15 extends HttpServlet {
    private BankAccountController controller = new BankAccountController();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "insert":
                insertForm(req, resp);
                break;
            case "update":
                updateForm(req, resp);
                break;
            case "delete":
                deleteForm(req, resp);
                break;
            case "select":
                selectForm(req, resp);
            default:
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String action = req.getParameter("action");
        switch (action) {
            case "insert": {
                insert(req, resp, out);
            }
            break;
            case "update": {
                update(req, resp, out);
            }
            break;
            case "delete": {
                delete(req, resp, out);
            }
            break;
            case "select": {
                select(req, resp, out);
            }
            break;
        }

    }

    private void insertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<form method='post' action='bank?action=insert'>");
        out.println("Name:<input type='text' name='name'><br>");
        out.println("Account No:<input type='number' name='account'><br>");
        out.println("Mobile No:<input type='number' name='mobile_no'><br>");
        out.println("Email id:<input type='email' name='email'><br>");
        out.println("Address:<input type='text' name='address'><br>");
        out.println("Balance:<input type='number' name='balance'><br>");
        out.println("<input type='submit' value='Insert Record '>");
        out.println("</form>");

    }
    private void insert(HttpServletRequest req, HttpServletResponse resp, PrintWriter writer) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String account = req.getParameter("account");
        String address = req.getParameter("address");
        String phone = req.getParameter("mobile_no");
        String balance= req.getParameter("balance");
        boolean res = controller.insertRecord(account, name, phone, email, address,balance);
        if (res) {
            writer.println("Record inserted successfully");
        } else {
            writer.println("Record not inserted successfully");
        }
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<form method='post' action='bank?action=update'>");
        out.println("Account No:<input type='text' name='account'><br>");
        out.println("Mobile No To Update:<input type='text' name='mobile_no'><br>");
        out.println("Address to update:<input type='text' name='address'><br>");
        out.println("<input type='submit' value='Update Record'>");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp, PrintWriter writer) throws ServletException, IOException {
        String account = req.getParameter("account");
        String mobile_no = req.getParameter("mobile_no");
        String address = req.getParameter("address");
        boolean b = controller.updateRecord(account, mobile_no, address);
        if(b)
        {
            writer.println("Record updated successfully");
        }
        else
        {
            writer.println("Record not updated successfully");
        }

    }

    private void deleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<form method='post' action='bank?action=delete'>");
        out.println("Account No :<input type='number' name='account'><br>");
        out.println("<input type='submit' value='Delete Record'>");
        out.println("</form>");
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp, PrintWriter writer) throws ServletException, IOException {
        String account=req.getParameter("account");
        var b = controller.deleteRecord(account);
        if (b)
        {
            writer.println("Record deleted successfully");
        }
        else {
            writer.println("Record not deleted successfully");
        }

    }

    private void selectForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<form method='post' action='bank?action=select'>");
        out.println("Account No:<input type='number' name='account'><br>");
        out.println("<input type='submit' value='Select Record'>");

    }
    private void select(HttpServletRequest req, HttpServletResponse resp, PrintWriter writer) throws ServletException, IOException {
        String account = req.getParameter("account");
        ResultSet rs = controller.selectRecord(account);
        try
        {
            if(rs.next())
            {
                writer.println("<table border=1>");
                writer.println("<tr>");
                writer.println("<th>Account No:</th>");
                writer.println("<th>Name:</th>");
                writer.println("<th>Mobile No:</th>");
                writer.println("<th>Email Id:</th>");
                writer.println("<th>Address:</th>");
                writer.println("<th>Balance:</th>");
                writer.println("</tr>");
                writer.println("<tr>");
                writer.println("<td>"+rs.getString("account_no")+"</td>");
                writer.println("<td>"+rs.getString("name")+"</td>");
                writer.println("<td>"+rs.getString("mobile_no")+"</td>");
                writer.println("<td>"+rs.getString("email")+"</td>");
                writer.println("<td>"+rs.getString("address")+"</td>");
                writer.println("<td>"+rs.getString("balance")+"</td>");
                writer.println("</tr>");
                writer.println("</table>");




            }
        }catch (SQLException e)
        {
            writer.println(e.getLocalizedMessage());
            e.printStackTrace();
        }


    }
}


class DBConnBank {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static final String url = "jdbc:mysql://localhost:3306/user_db";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() {
        try {

            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}

class BankAccountController {
    Connection con = DBConnBank.getConnection();

    public boolean insertRecord(String account, String name, String mobileNo, String email, String address,String  balance) {
        String sqlInsert = "insert into account(account_no,name,mobile_no,email,address,balance) values(?,?,?,?,?,?)";
        try {

            PreparedStatement statement = con.prepareStatement(sqlInsert);
            statement.setString(1, account);
            statement.setString(2, name);
            statement.setString(3, mobileNo);
            statement.setString(4, email);
            statement.setString(5, address);
            statement.setString(6, balance);
            if (statement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return false;
    }
    public boolean updateRecord(String account,   String mobileNo,   String address ) {
        String updateSql="update account set mobile_no=?,address=? where account_no=? ";
        try
        {
            PreparedStatement statement = con.prepareStatement(updateSql);
            statement.setString(1, mobileNo);
            statement.setString(2, address);
            statement.setString(3, account);
            return statement.executeUpdate() > 0;
        }catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        return false;
    }
    public boolean deleteRecord(String account ) {
        String sql="delete from account where account_no=?";
        try
        {
            PreparedStatement statement =con.prepareStatement(sql);
            statement.setString(1, account);
            return statement.executeUpdate() > 0;
        }catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        return false;
    }
    public ResultSet selectRecord(String account) {
        String sql="select * from account where account_no=?";
        try
        {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, account);
            ResultSet rs = statement.executeQuery();
            return rs;
        }catch (SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}

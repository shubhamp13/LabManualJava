package com.question17;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/question17/student")
public class StudentServlet extends HttpServlet
{
    private  StudentController controller=new StudentController();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String action=req.getParameter("action");
         PrintWriter out=resp.getWriter();
         switch (action)
         {
             case "insert":{
                 insertForm(req,resp,out);
             }
             break;
             case "update":{
                 updateForm(req,resp,out);
             }
             break;
             case "delete":{
                 deleteForm(req,resp,out);
             }
             break;
             case "select":{
                 selectForm(req,resp,out);
             }
             break;
         }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        String action=req.getParameter("action");
        switch (action)
        {
            case "insert":{
                insert(req,resp,out);
            }
            break;
            case "update":{
                update(req,resp,out);
            }
            break;
            case "delete":{
                delete(req,resp,out);
            }
            break;
            case "select":{
                select(req,resp,out);
            }
            break;
        }

    }

    private  void  insertForm(HttpServletRequest req, HttpServletResponse resp, PrintWriter out)throws  ServletException
    {
        resp.setContentType("text/html");
        out.println("<form action='student?action=insert' method='post'>'");
        out.println("Name:<input type=\"text\" name=\"name\">");
        out.println("Phone No:<input type=\"number\" name=\"phone\">");
        out.println("Email:<input type=\"text\" name=\"email\">");
        out.println("Address:<input type=\"address\" name=\"address\">");
        out.println("<input type=\"submit\" value=\"Insert\">");
    }
    private void insert(HttpServletRequest req, HttpServletResponse resp,PrintWriter out) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        if(name!=null && phone!=null && email!=null && address!=null)
        {
          if(controller.insert(name,phone,email,address))
          {
              out.println("<h1>Record Inserted Successfully</h1>");
          }
          else
          {
              out.println("<h1>Record Insertion Failed</h1>");
          }
        }

    }
    private void updateForm(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        resp.setContentType("text/html");
        out.println("<form action='student?action=update' method='post'>'");
        out.println("Phone No:<input type=\"number\" name=\"phone\"><br>");
        out.println("Address To Update:<input type=\"text\" name=\"address\"><br>");
        out.println("<input type=\"submit\" value=\"Update\">");
    }
    private void update(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        resp.setContentType("text/html");
        String number = req.getParameter("phone");
        String address = req.getParameter("address");
        if(number!=null && address!=null)
        {
            if(controller.update(number,address))
            {
                out.println("<h1>Record Updated Successfully</h1>");
            }
            else {
                out.println("<h1>Record Update Failed</h1>");
            }
        }
    }
    private void deleteForm(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        resp.setContentType("text/html");
        out.println("<form action='student?action=delete' method='post'>'");
        out.println("Phone No:<input type=\"number\" name=\"phone\"><br>");
        out.println("<input type=\"submit\" value=\"Delete\">");
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        resp.setContentType("text/html");
        String number = req.getParameter("phone");
        if(number!=null)
        {
            if(controller.delete(number))
            {
                out.println("<h1>Record Deleted Successfully</h1>");
            }
            else{
                out.println("<h1>Record Deletion Failed</h1>");
            }
        }
    }
    private void selectForm(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        resp.setContentType("text/html");
        out.println("<form action='student?action=select' method='post'>'");
        out.println("Phone No:<input type=\"text\" name=\"phone\">");
        out.println("<input type=\"submit\" value=\"Select\">");
    }
    private void select(HttpServletRequest req, HttpServletResponse resp, PrintWriter out) throws ServletException, IOException {
        resp.setContentType("text/html");
        String number = req.getParameter("phone");
        if(number!=null)
        {
            ResultSet rs=controller.getRecord(number);
            try
            {
                if(rs.next())
                {
                    out.println("<table border=1>");
                    out.println("<tr>");
                    out.println("<th>Name:</th>");
                    out.println("<th>Address:</th>");
                    out.println("<th>Phone:</th>");
                    out.println("<th>Email:</th>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td>"+rs.getString("name")+"</td>");
                    out.println("<td>"+rs.getString("address")+"</td>");
                    out.println("<td>"+rs.getString("phone")+"</td>");
                    out.println("<td>"+rs.getString("email")+"</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                }
                else
                {
                    out.println("<h1>Record Not Found</h1>");
                }
            }catch (SQLException e)
            {
              out.println(e.getMessage());
            }
        }
    }
}
class StudentController
{
    Connection con = DBConnStudent.getConnection();
    public  boolean insert(String name,String phone,String email,String address)
    {
        String sql="insert into student(name,phone,email,address) values(?,?,?,?)";
        try
        {

            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,phone);
            pstmt.setString(3,email);
            pstmt.setString(4,address);
            return pstmt.executeUpdate()>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean update(String phone,String address)
    {
        String sql="update student set address=? where phone=?";
        try
        {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,address);
            ps.setString(2,phone);
            return ps.executeUpdate()>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean delete(String phone)
    {
        String sql="delete from student where phone=?";
        try
        {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,phone);
            return ps.executeUpdate()>0;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public ResultSet getRecord(String phone)
    {
        String sql="select * from student where phone=?";
        try
        {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,phone);
            ResultSet rs=ps.executeQuery();
            return rs;
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

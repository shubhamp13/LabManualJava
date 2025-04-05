<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Shubham
  Date: 04-04-2025
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%!
  String url="jdbc:mysql://localhost:3306/user_db";
  String userName="root";
  String password="root";
  Connection conn=null;
  PreparedStatement ps=null;
  Statement stmt=null;
  ResultSet rs=null;
%>

<%
  try
  {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn= DriverManager.getConnection(url,userName,password);
  }catch (SQLException | ClassNotFoundException e)
  {
    out.println(e.getLocalizedMessage());
  }
%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register.jsp">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" placeholder="Enter Your Name" required><br>
  <label for="email">Email:</label>
  <input type="email" name="email" id="email" required placeholder="Enter Your Email"><br>
  <label for="password">Password:</label>
  <input type="password" name="password" id="password" required><br>

  <label for="phone">Phone No:</label>
  <input type="number" id="phone" name="phone" required><br>
  <input type="submit" value="Register">
  <button type="button"><a href="login.jsp">Login</a></button>

</form>

<%
  String name=request.getParameter("name");
  String email=request.getParameter("email");
  String password=request.getParameter("password");
  String phone=request.getParameter("phone");
  if(name!=null && email!=null && password!=null && phone!=null )
  {
    String query="insert into users(name,email,password,phone)values(?,?,?,?)l;";
    ps=conn.prepareStatement(query);
    ps.setString(1,name);
    ps.setString(2,email);
    ps.setString(3,password);
    ps.setString(4,phone);
    ps.executeUpdate();
    out.println("<b>Registered Successfully</b>");
  }
%>
</body>
</html>

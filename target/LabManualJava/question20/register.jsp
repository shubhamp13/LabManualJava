<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>
<%!
    public  String url="jdbc:mysql://localhost:3306/user_db";
    public  String userName="root";
    public  String pass="root";
    Connection connection=null;
    Statement tmt=null;
    PreparedStatement ps=null;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
</form>
<%
    String name=request.getParameter("name");
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    String phone=request.getParameter("phone");
    if(name!=null && email!=null && password!=null && phone!=null)
    {
        String sql="insert into users (name,email,password,phone)values(?,?,?,?)";
        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,password);
        ps.setString(4,phone);
        ps.executeUpdate();
        response.setContentType("text/html");
        out.println("<h1>Registerd");

    }
%>


</body>

</html>

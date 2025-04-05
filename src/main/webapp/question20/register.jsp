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
<%
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection=DriverManager.getConnection(url,userName,pass);
    }catch (Exception e)
    {
        out.println(e.getLocalizedMessage());
    }
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
    try
    {
        if(name!=null && email!=null && password!=null && phone!=null)
        {
            String sql="insert into users (name,email,password,phone)values(?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,password);
            ps.setString(4,phone);
            ps.executeUpdate();
            response.setContentType("text/html");
            out.println("<h1>Registerd");

        }
    }catch (Exception e)
    {
        out.println(e.getLocalizedMessage());
    }

%>
<%
    String query="select name,email,phone from users;";
    Statement statement=connection.createStatement();
    ResultSet rs=statement.executeQuery(query);
%>
<h3>User Details</h3>
<table style="width:100%" border="2px solid black">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    <%
        while (rs.next())
        {
    %>
    <tr>
        <td><%=rs.getString("name")%></td>
        <td><%=rs.getString("email")%></td>
        <td><%=rs.getString("phone")%></td>
    </tr>
    <%
        }
    %>

</table>


</body>

</html>

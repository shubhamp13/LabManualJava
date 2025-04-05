<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
</head>
<body>
<h1>Login!</h1>
<form action="login.jsp" method="post">
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password" required><br>
  <input type="submit" value="Login">
</form>

<%
  String url = "jdbc:mysql://localhost:3306/user_db";
  String username = "root";
  String password = "root";  // Use environment variables in production

  Connection conn = null;
  PreparedStatement ps = null;
  ResultSet rs = null;

  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection(url, username, password);

    String email = request.getParameter("email");
    String userPassword = request.getParameter("password");

    if (email != null && userPassword != null) {
      String query = "SELECT name, password, phone FROM users WHERE email=?";
      ps = conn.prepareStatement(query);
      ps.setString(1, email);
      rs = ps.executeQuery();

      if (rs.next()) {
        String storedPassword = rs.getString("password");
        if (storedPassword.equals(userPassword)) {  // Replace with password hashing
          out.println("<p>Logged in successfully</p>");
          out.println("<p>Name: " + rs.getString("name") + "</p>");
          out.println("<p>Email: " + email + "</p>");
          out.println("<p>Phone: " + rs.getString("phone") + "</p>");
        } else {
          out.println("<p style='color:red;'>Invalid Password</p>");
        }
      } else {
        out.println("<p style='color:red;'>User not found. Please register first.</p>");
        response.sendRedirect("register.jsp");
      }
    }
  } catch (Exception e) {
    out.println("<p style='color:red;'>Error: " + e.getLocalizedMessage() + "</p>");
  } finally {
    try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
    try { if (ps != null) ps.close(); } catch (SQLException ignored) {}
    try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
  }
%>

</body>
</html>

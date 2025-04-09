<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>
</head>
<body>
<h2>
  <%
    String msg = (String) request.getAttribute("msg");
    out.print(msg);
  %>
</h2>
</body>
</html>

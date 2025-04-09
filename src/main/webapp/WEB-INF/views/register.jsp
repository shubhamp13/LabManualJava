<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>User Registration</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>

<h2>Register</h2>

<form:form method="post" modelAttribute="user">
    Username: <form:input path="username" />
    <form:errors path="username" cssClass="error" /><br><br>

    Email: <form:input path="email" />
    <form:errors path="email" cssClass="error" /><br><br>

    Password: <form:password path="password" />
    <form:errors path="password" cssClass="error" /><br><br>

    <input type="submit" value="Register" />
</form:form>

</body>
</html>

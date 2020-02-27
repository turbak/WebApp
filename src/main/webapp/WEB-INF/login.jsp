<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  User: administrator
  Date: 20.02.2020
  Time: 11:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div style="text-align: center;">
${message}
<h1>Login</h1>
    <spring:form method="post" action="login" modelAttribute="profile">
        <spring:input path="login" placeholder="Login"/><br>
        <spring:password path="password" placeholder="Password"/><br>
        <input type="submit" value="OK">
    </spring:form>
    <br>
    <a href="register">Register</a>
</div>
</body>
</html>

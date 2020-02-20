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
<h1>Login</h1>
    <spring:form method="post" action="login" modelAttribute="userForm">
        <spring:input path="name" placeholder="Login"/>
        <spring:password path="password" placeholder="Password"/>
        <input type="submit" value="OK">
    </spring:form>
</body>
</html>

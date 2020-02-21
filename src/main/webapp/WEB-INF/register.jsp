<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  User: administrator
  Date: 20.02.2020
  Time: 16:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Register</title>
</head>
<body>
${message}
<spring:form method="post" action="register" modelAttribute="user">
    <spring:input path="name" placeholder="Login"/><br>
    <spring:password path="password" placeholder="Password"/><br>
    <spring:input path="firstName" placeholder="Имя"/><br>
    <spring:input path="lastName" placeholder="Фамилия"/><br>
    <input type="submit" value="OK">
</spring:form>
</body>
</html>

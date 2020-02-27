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
<div style="text-align: center;">
    <h1>Registration</h1>
<spring:form method="post" action="register" modelAttribute="profile">
    <spring:input path="login" placeholder="Login"/><br>
    <spring:password path="password" placeholder="Password"/><br>
    <spring:input path="name" placeholder="Имя"/><br>
    <spring:input path="surname" placeholder="Фамилия"/><br>
    <spring:select path="referrer.id">
        <spring:option value = "" label = "Select your referrer"/>
        <spring:options items = "${referrers}" itemValue="Id" itemLabel="Ref_name"/>
    </spring:select>
    <input type="submit" value="OK">
</spring:form>
</div>
</body>
</html>

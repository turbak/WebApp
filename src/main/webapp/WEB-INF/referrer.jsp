<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  User: administrator
  Date: 27.02.2020
  Time: 16:55
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register referrer</title>
</head>
<body>
<div style="text-align: center;">
<h1>Registration</h1>
    <spring:form method="post" action="referrer" modelAttribute="referrer">
        <spring:input path="ref_name" placeholder="Name"/><br>
        <spring:input path="num_of_followers" placeholder="Number of followers"/><br>
        <input type="submit" value="OK">
    </spring:form>
</div>
</body>
</html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  User: administrator
  Date: 28.02.2020
  Time: 15:33
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Modify profile</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Modify profile of user ${username}</h1>
    <spring:form method="post" action="/update" modelAttribute="profile">
        <spring:input path="name" placeholder="Name"/>
        <spring:input path="surname" placeholder="Surname"/>
        <spring:select path="referrer.id">
            <spring:option value = "0" label = "Select your referrer"/>
            <spring:options items = "${referrers}" itemValue="Id" itemLabel="RefName"/>
        </spring:select>
        <input type="submit" value="Submit"/>
    </spring:form>
</div>
</body>
</html>

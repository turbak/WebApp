<%--
  Created by IntelliJ IDEA.
  User: administrator
  Date: 17.02.2020
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
<form id="login" action="login" method="post">
    <h1>Login</h1>
    <fieldset id="inputs">
        <input id="username" type="text" placeholder="Логин" name="login" autofocus required>
        <input id="password" type="password" placeholder="Пароль" name="password" required>
    </fieldset>
    <fieldset id="actions">
        <input type="submit" id="submit" name="submit" value="OK">
        <a href="register.jsp">Регистрация</a>
    </fieldset>
</form>
</body>
</html>

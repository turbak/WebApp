<%--
  User: administrator
  Date: 18.02.2020
  Time: 12:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
<form id="login" action="register" method="post">
    <h1>Register</h1>
    <fieldset id="inputs">
        <input id="username" type="text" placeholder="Логин" name="login" autofocus required>
        <input id="password" type="password" placeholder="Пароль" name="password" required>
        <input id="name" type="text" name="name" placeholder="Имя" required>
        <input id="surname" type="text" name="surname" placeholder="Фамилия" required>
    </fieldset>
    <fieldset id="actions">
        <input type="submit" id="submit" name="submit" value="OK">
    </fieldset>
</form>
</body>

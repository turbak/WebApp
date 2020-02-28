<%--
  User: administrator
  Date: 20.02.2020
  Time: 13:02
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div style="text-align: center;">
        <h1>Main page</h1>
            Привет, ${profile.name} ${profile.surname}<br>
            <a href="exit">Exit</a><br>
        <a href="profiles">View profiles</a><br>
        <a href="update">Modify profile</a>
        ${profile.admin == true ? "<a href=admin>Admin panel</a>" : ""}
    </div>
</body>
</html>

<%--
  User: administrator
  Date: 27.02.2020
  Time: 16:35
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${profileName}</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Profile of user ${profileName}</h1>
    ${profile.name} ${profile.surname}<br>
    Referrer: ${referrer.refName}<br>
    Num of followers: ${referrer.numOfFollowers}
</div>
</body>
</html>

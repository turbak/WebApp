<%@ page import="ru.test.entity.Profile" %>
<%@ page import="java.util.List" %><%--
  User: administrator
  Date: 25.02.2020
  Time: 15:55
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="text-align: center;">
    <h1>View Profiles</h1>
    <% List<Profile> list = (List<Profile>) request.getAttribute("profiles");
        for (Profile profile : list) {
        	if (profile != null) {
                out.println(profile);
                out.println("<a href=\"/profiles/" + profile.getLogin() + "\">View</a><br>");
            }
        }
    %>
</div>
</body>
</html>

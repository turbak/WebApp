<%@ page import="ru.spring.entity.Profile" %>
<%@ page import="java.util.List" %><%--
  User: administrator
  Date: 25.02.2020
  Time: 15:55
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>View Profiles</title>
</head>
<body>
<div style="text-align: center;">
    <h1>View Profiles</h1>
    <% List<Profile> list = (List<Profile>) request.getAttribute("profiles");
        for (Profile profile : list) {
        	if (profile != null) {
                out.print("<div id=\"" + profile.getLogin() + "\" >");
                out.println(profile);
                out.println("<a href=\"/profiles/" + profile.getLogin() + "\">View</a><br>");
                out.print("</div>");
            }
        }
    %>
</div>
</body>
</html>

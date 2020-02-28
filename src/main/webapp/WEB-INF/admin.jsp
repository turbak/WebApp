<%@ page import="ru.test.entity.Profile" %>
<%@ page import="java.util.List" %><%--
  User: administrator
  Date: 28.02.2020
  Time: 12:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
    <div style="text-align: center;">
        <h1>List of all registered profiles</h1>
        <table>
            <tr>
                <th>Login</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Delete</th>
            </tr>
    <% List<Profile> profiles = (List<Profile>) request.getAttribute("profiles");
        for (Profile profile : profiles) {
        	out.println(String.format("<tr>" +
                    "<td>%s</td>" +
                    "<td>%s</td>" +
                    "<td>%s</td>" +
                    "<td>%s</td>" +
                    "</tr>", profile.getLogin(), profile.getName(), profile.getSurname(),
                    "<a href = \"delete/" + profile.getLogin() + "\">Delete</a>"));
        }
    %>
        </table>
    </div>
</body>
</html>

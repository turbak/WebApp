<%@ page import="ru.spring.entity.Profile" %>
<%@ page import="java.util.List" %><%--
  User: administrator
  Date: 28.02.2020
  Time: 12:58
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <title>Admin page</title>
</head>
<script type="text/javascript">
    function deleteLogin(login) {
        $.get("/delete/" + login, null
        ).done($("#" + login).remove());
    }
</script>
<body>
    <div style="text-align: center;">
        <h1>List of all registered profiles</h1>
        <table  style="border:1px solid black;margin-left:auto;margin-right:auto;">
            <tr>
                <th>Id</th>
                <th>Login</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Delete</th>
            </tr>
    <% List<Profile> profiles = (List<Profile>) request.getAttribute("profiles");
        for (Profile profile : profiles) {
        	out.println(String.format(
        			"<tr id=\"%s\">" +
                    "<td>%s</td>" +
                    "<td>%s</td>" +
                    "<td>%s</td>" +
                    "<td>%s</td>" +
                    "<td>%s</td>" +
                    "</tr>", profile.getLogin(), profile.getId(), profile.getLogin(), profile.getName(), profile.getSurname(),
                    "<button id=\"delete\" onclick=\"deleteLogin("+ profile.getLogin() + ")\">Delete</button>"));
        }
    %>
        </table>
    </div>
</body>
</html>

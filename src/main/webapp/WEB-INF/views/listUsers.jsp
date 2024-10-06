<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<html>
<head><title>List Users</title></head>
<body>
    <h1>User List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>
                    <a href="edit?id=${user.userId}">Edit</a> |
                    <a href="delete?id=${user.userId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="addUser.jsp">Add New User</a>
</body>
</html>

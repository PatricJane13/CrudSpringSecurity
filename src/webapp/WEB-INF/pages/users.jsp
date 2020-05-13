<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table width="50%" border="1" cellpadding="8">
    <tr>
        <td><c:out value="First Name"/></td>
        <td><c:out value="Last Name"/></td>
        <td><c:out value="Email"/></td>
        <td><c:out value="Update"/></td>
        <td><c:out value="Delete"/></td>
        <td><c:out value="Update Role"/></td>
    </tr>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td><c:out value="${message.firstName}"/></td>
            <td><c:out value="${message.lastName}"/></td>
            <td><c:out value="${message.email}"/></td>
            <td>
                <form action="/admin/getUpdate">
                    <input hidden type="text" name="id" value="${message.id}">
                    <button>Update</button>
                </form>
            </td>
            <td>
                <form action="/admin/delete">
                    <input hidden type="text" name="id" value="${message.id}">
                    <button>Delete</button>
                </form>
            </td>
            <td>
                <form action="/admin/updateRole" method="post">
                    <input hidden type="text" name="id" value="${message.id}">
                    <select name="selectRole">
                        <option>ADMIN</option>
                        <option>USER</option>
                    </select>
                    <button>Update Role</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="/admin/add" method="post">
    Firs Name:<br>
    <input type="text" name="firstName"><br><br>
    Last Name:<br>
    <input type="text" name="lastName"><br><br>
    Email:<br>
    <input type="text" name="email"><br><br>
    Password:<br>
    <input type="text" name="password"><br><br>
    Role:<br>
    <input type="text" name="role">
    <button>Let's go...</button>
</form>
<a href="/logout">Logout</a>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/admin/update" method="post" ${requestScope.user}>
    <input type="hidden" value="${requestScope.user.id}" name="id">
    NewFirstName:<br>
    <input type="text" value="${user.firstName}" name="newFirstName"><br><br>
    NewLastName:<br>
    <input type="text" value="${user.lastName}" name="newLastName"><br><br>
    NewEmail:<br>
    <input type="text" value="${user.email}" name="newEmail"><br><br>
    NewPassword:<br>
    <input type="text" value="${user.password}" name="newPassword"><br><br>
    <button formmethod="post">Let's go update...</button>
</form>
</body>
<a href="<c:url value="/logout" />">Logout</a>
</html>

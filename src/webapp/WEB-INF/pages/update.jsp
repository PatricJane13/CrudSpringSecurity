<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/update" method="post" ${requestScope.user}>
    <input type="hidden" value="${requestScope.user.id}" name="id">
    NewFirstName:<br>
    <input type="text" name="newFirstName"><br><br>
    NewLastName:<br>
    <input type="text" name="newLastName"><br><br>
    NewEmail:<br>
    <input type="text" name="newEmail"><br>
    <button formmethod="post">Let's go update...</button>
</form>
<form action="/update" method="post">

    <button>Go...</button>
</form>
</body>
</html>

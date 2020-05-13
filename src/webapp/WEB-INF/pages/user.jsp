<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09.05.2020
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<table width="50%" border="1" cellpadding="8">
    <tr>
        <td><c:out value="First Name"/></td>
        <td><c:out value="Last Name"/></td>
        <td><c:out value="Email"/></td>
    </tr>
    <input type="hidden" ${user}>
    <tr>
        <td><c:out value="${user.firstName}"/></td>
        <td><c:out value="${user.lastName}"/></td>
        <td><c:out value="${user.email}"/></td>
    </tr>
</table>
<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>

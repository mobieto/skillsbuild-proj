<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form:form action="/register-form" method="post" modelAttribute="user">
        User Name: <form:input type="text" name="username"  path="name"/> <br/>
        Password: <form:input type="password" name="password" path="password"/> <br/>
        <input type="submit" value="Register" /> <br/>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
    </form:form>
</body>
</html>


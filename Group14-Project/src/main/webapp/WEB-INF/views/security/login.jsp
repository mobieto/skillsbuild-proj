<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form action="/myLogin" method="post">
        User Name: <input type="text" name="username" /> <br/>
        Password: <input type="password" name="password" /> <br/>
        <input type="submit" value="Sign In" /> <br/>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
        <p> or <a href="/register-form">register</a></p>
    </form>
</body>
</html>


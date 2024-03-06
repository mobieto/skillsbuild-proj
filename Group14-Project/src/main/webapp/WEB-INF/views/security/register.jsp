<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="https://www.ibm.com/content/dam/adobe-cms/default-images/favicon.svg">
    <title>Register for SkillsBuild</title>
</head>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 10px;
        background-color: #ffffff;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        min-height: 10vh;
    }

    header {
        padding: 20px;
        text-align: center;
        margin: 0;
        box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
    }

    #ibm-logo {
        max-width: 30%;
        height: auto;
        display: block;
        margin: 20px auto;
        box-shadow: 0 0 20px rgb(255, 255, 255);
    }

    #typing-message {
        overflow: hidden;
        white-space: nowrap;
        text-align: center;
        margin: 10px;
        font-size: 24px;
        animation: typing 10s steps(100);
        color: #0f75bc;
    }

    @keyframes typing {
        from { width: 0 }
        to { width: 100% }
    }

    form {
        text-align: center;
        margin-top: 100px;
        max-width: 600px;
        padding: 40px;
        padding-left: 5px;
        width: 90%;
        display: block;
        margin: 20px auto;
        box-shadow: 0 0 10px rgb(0, 0, 0, 0.5)
    }

    input[type="text"],
    input[type="password"] {
        padding: 15px;
        margin-bottom: 20px;
        width: 100%;
        border: 2px solid #0f75bc;
        border-radius: 5px;
        outline: none;
    }

    input[type="submit"] {
        padding: 15px 30px;
        background-color: #0f75bc;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover {
        background-color: #095c91;
    }
</style>
</head>
<body>
<header>
    <img id="ibm-logo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/IBM_logo.svg/2560px-IBM_logo.svg.png">
</header>

<div id="typing-message">Gamify your IBM experience!</div>
<body>
    <form:form action="/register-form" method="post" modelAttribute="user">
        User Name: <form:input type="text" name="username"  path="name"/> <br/>
        Password: <form:input type="password" name="password" path="password"/> <br/>
        <input type="submit" value="Register" /> <br/>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
    </form:form>
</body>
</html>


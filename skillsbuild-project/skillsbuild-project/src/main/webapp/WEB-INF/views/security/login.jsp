<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="https://www.ibm.com/content/dam/adobe-cms/default-images/favicon.svg">
    <title>Login to SkillsBuild</title>
</head>
<style>
    body {
        font-family: 'Arial', sans-serif;
        color: white;
        margin: 0;
        padding: 10px;
        background:#081b29;
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
        margin-top: 50px;
        max-width: 600px;
        padding: 40px;
        padding-left: 5px;
        width: 90%;
        display: block;
        margin: 20px auto;
        box-shadow: 0 0 20px rgb(255, 255, 255);
    }
    input[type="text"],
    input[type="password"] {
        padding: 15px;
        margin-bottom: 20px;
        width: 100%;
        border: 2px solid #0f75bc;
        border-radius: 5px;
        outline: none;
        align-items: center;
        justify-content: center;
    }
    input[type="submit"],
    .register-button {
        padding: 15px 30px;
        background-color: #0f75bc;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
        text-decoration: none;
        width: calc(25% - 30px);
        font-size: 16px;
        align-items: center;
        justify-content: center;
    }
    input[type="submit"]:hover,
    .register-button:hover {
        background-color: #095c91;
    }
    .register-button {
        margin-top: 10px;
    }

</style>
</head>
<body>
<header>
    <img id="ibm-logo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/IBM_logo.svg/2560px-IBM_logo.svg.png">
</header>
<div id="typing-message">Gamify your IBM experience!</div>
<body>
    <form action="/myLogin" method="post" style="align-items: center;">
         User Name: <input type="text" name="username" /> <br/>
         Password: <input type="password" name="password" /> <br/>
        <input type="submit" value="Sign In" /> <br/><br/>
<%--        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">--%>
        <a href="/register-form" class="register-button">Register</a>
    </form>
</body>
</html>


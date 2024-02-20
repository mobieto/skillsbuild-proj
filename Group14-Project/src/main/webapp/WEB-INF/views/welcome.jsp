<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to IBM Skillsbuild</title>
    <link rel="stylesheet" href="/welcome.css" />
    <style>
        *{
            text-decoration: none;
        }
        .navbar {
            font-family: Arial;
            padding: 50px 0;
            display: flex;
            align-items: center;
            justify-content: center;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1000;
        }

        .navdiv {
            display: flex;
            align-items: center;
            justify-content: space-between;
            width: 100%;
            max-width: 1200px;
            margin: 0 auto;
            padding-left: 1000px;
        }

        .logo a {
            font-size: 25px;
            font-weight: 600;
            color: black;
        }

        li {
            list-style: none;
            display: inline-block;
        }

        li a {
            color: black;
            font-size: 10px;
            font-weight: normal;
            margin-right: 25px;
        }

        button {
            background-color: black;
            margin-left: 10px;
            border-radius: 10px;
            padding: 10px;
            width: 90px;
        }

        button a {
            color: #095c91;
            font-weight: bold;
            font-size: 15px;
        }

        body {
            background-color: white;
            color: #0f75bc;
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 120px;
            margin: 0;
        }

        #ibm-logo {
            max-width: 30%;
            padding: 20px;
            height: auto;
            display: block;
            margin: 20px auto;
            box-shadow: 0 0 10px rgb(0, 0, 0, 0.5)
        }


        .container {
            max-width: 600px;
            margin: 0 auto;
        }


        .btn {
            display: inline-block;
            padding: 0.35rem;
            background-color: #0f75bc;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
            border: 1px black;
            margin-left: 0.35rem;
        }

        .btn:hover {
            transform: scale(1.05);
        }

        .btn:active {
            transform: scale(0.95);
        }

        footer{
            display: block;
            align-items: center;
            justify-content: center;
            font-size: 14px;
        }

        .login {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .login p{
            color: #095c91;
        }

 /*
    </style>
</head>
<header>
    <nav class="navbar">
        <div class="navdiv">
            <div class="logo">
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="/login-form">Login</a><li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<body>
<img id="ibm-logo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/IBM_logo.svg/2560px-IBM_logo.svg.png">
<div class="container">
    <h1>Welcome to IBM SkillsBuild</h1>
    <p>Get started with our courses and unlock your potential.</p>
    <p>Login to enroll in our courses and accelerate your career.</p>

</div>
<footer>
    <div class="login">
        <p>Register to get started with courses -</p>
        <a href="/register-form" class="btn">Register</a>
    </div>
   <div class="login">
       <p>Already have an account?</p>
       <a href="/login-form" class="btn">Login</a>
   </div>
</footer>
</body>
</html>

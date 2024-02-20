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
            background: white;
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
            color: #095c91;
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
            box-shadow: 0 5px 10px rgb(0, 0, 0)
        }


        .container {
            max-width: 600px;
            margin: 0 auto;
        }


        .btn {
            display: inline-block;
            padding: 10px 20px;
            margin: 10px;
            background-color: white;
            color: #095c91;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            font-weight: bold;
        }


 /*
    </style>
</head>
<header>
    <nav class="navbar">
        <div class="navdiv">
            <div class="logo">
                <ul>
                    <li><a href="/welcome.css">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="/register-form">Login</a><li>
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
    <a href="#" >Get Started with Courses</a>
    <a href="/register-form" class="btn">Login</a>
</footer>
</body>
</html>

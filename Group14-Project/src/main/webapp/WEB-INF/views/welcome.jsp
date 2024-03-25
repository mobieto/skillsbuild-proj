<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to IBM Skillsbuild</title>
    <link rel="stylesheet" href="/welcome.css" />
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
</head>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap');

        *{
            margin: 0;
            padding-right: 0;
            box-sizing: border-box;
            font-family: "IBM Plex Sans", sans-serif;
            list-style-type: none;
        }
        body {
            height: 80vh;
            background:#081b29;
            display: flex;
            color: #ffffff;
            align-items: center;
            padding-top: 120px;


        }
        .header {
            background: transparent;
            display: flex;
            align-items: center;
            justify-content: space-between;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            padding: 20px 100px;
            z-index: 100;
        }

        .logo {
            font-size: 32px;
            color: white;
            text-decoration: none;
            font-weight: 700;
            font: "IBM Plex Sans", sans-serif;
        }

        .navbar {
            list-style-type: none;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 0;
        }

        .navbar li {
            margin: 0 20px;
        }

        .navbar a {
            font-size: 18px;
            color: white;
            font-weight: 500;
            text-decoration: none;
        }

        .navbar a:hover {
            color: #00abf0;
            transition: .3s;
        }

        button{
            border:none;
            background: #3ddbd9;
            padding: 12px 30px;
            border-radius: 30px;
            color: white;
            font-weight: bold;
            font-size: 15px;
            transition: .4s;
        }
        button:hover{
            transform: scale(1.2);
            cursor: pointer;
        }



        .home-content {
            background: transparent;
            max-width: 600px;
            padding: 0 20%;
        }

        .home-content h1 {
            font-size: 40px ;
            font-weight: 700;
            color: #fff;
            text-shadow: 0 0 10px #3ddbd9, 0 0 20px #3ddbd9, 0 0 30px #3ddbd9;
            padding-bottom: 30px;

        }

        .home-content h3 {
            font-size: 22px;
            font-weight: 700;
            color: #00abf0;
        }

        .home-content p {
            font-size: 16px;
        }

        .login {
            margin-top: 10px ;
            align-items: center;
        }
        .btn {
            margin-top: 10px;
            display: inline-flex;
            justify-content: center;
            align-items: center;
            width: 150px;
            height: 100%;
            background: #3ddbd9;
            padding: 5px 30px;
            border-radius: 50px;
            color: white;
            text-decoration: none;
            font-size: 15px;
            font-weight: 700;
            letter-spacing: 1px;
            transition: 0.4s;

        }

        .btn:hover {
            transform: scale(1.2);
            cursor: pointer;
        }
        .home-sm {
            position: absolute;
            bottom: 40px;
            width: 120px;
            display: flex;
            justify-content: space-between;
        }
        .home-sm a {
            position: relative;
            display: inline-flex;
            justify-content: center;
            align-items: center;
            width: 40px;
            height: 40px;
            border: 2px solid #00abf0;
            background: transparent;
            border-radius: 50%;
            font-size: 20px;
            color: #00abf0;
            text-decoration: none;

        }
        #ibm-logo {
            position: fixed;
            right: 30px;
            padding-right: 50px;
            top: 50%;
            transform: translateY(-50%);
            width: 40%;

        }




    </style>

<img>
<header class="header">
    <a href="#" class="logo">IBM</a>
    <nav class="navbar">
        <ul>
            <li><a href="#">Home</a></li>
        </ul>
        <button><a href="/login-form" class="button">Login</a></button>
    </nav>
</header>
<img id="ibm-logo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/IBM_logo.svg/2560px-IBM_logo.svg.png">
<section class="home">
    <div class ="home-content">
        <h1>Welcome to IBM SkillsBuild</h1>
        <h3>Get started with our courses and unlock your potential.</h3>
        <p>Login to enroll in our courses and accelerate your career.</p>
    <div class="login">
        <p>Register to get started with courses</p>
        <a href="/register-form" class="btn">Register</a>
    </div>
    <div class="login">
        <p>Already have an account?</p>
        <a href="/login-form" class="btn">Login</a>
    </div>
        <div class="home-sm">
        <a href="https://www.instagram.com/ibm/"><i class='bx bxl-instagram'></i></a>
        <a href="https://www.facebook.com/IBM/"><i class='bx bxl-facebook-circle'></i></a>
        </div>

</section>

</body>
</html>

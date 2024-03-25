<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="https://www.ibm.com/content/dam/adobe-cms/default-images/favicon.svg">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Course Sessions</title>
    <style>
        input[type="submit"] {
            background-color: #0f75bc;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
        }


        body {
            background-color: #f4f7fc;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #132c33;
            padding-left: 10px;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            background-color: #ffffff;
            margin-left: 5px;
            margin-right: 5px;
            padding: 10px;
            border: 1px solid #d1d1d1;
            border-radius: 5px;
        }

        form {
            margin-top: 10px;
            padding-left: 10px;
        }

        input[type="text"] {
            padding: 5px;
            margin: 5px;
            border: 1px solid #132c33;
            border-radius: 3px;
        }

        #dashboard {
            text-align: center;
            margin: 10px;
            font-size: 18px;
        }

        header {
            padding: 10px;
            margin: 0;
            box-shadow: 0 5px 1px rgba(0, 0, 0, 0.2);
        }
        #logo1 {
            width: 15%;
            height: 10%;
            display: block;
            margin: 20px auto;
            box-shadow: 0 0 20px rgb(255, 255, 255);
        }
        a {
            color: #0f75bc;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            color: #0f75bc
        }
        h3 {
            color: #0f75bc;
        }
        p {
            color: #0f75bc;
        }
        .home-sm {
            display: flex;
            justify-content: center;
        }
        .home-sm a {
            display: inline-flex;
            justify-content: center;
            align-items: center;
            width: 40px;
            height: 40px;
            border: 2px solid #0f75bc;
            background: transparent;
            border-radius: 50%;
            font-size: 20px;
            color: #00abf0;
            text-decoration: none;
            transition: background-color 0.3s;
            margin: 5px;
        }
        .home-sm a:hover {
            background-color: rgba(0, 0, 0, 0.1);
        }
        .footer {
            color: #0f75bc;
            text-align: center;
            padding: 155px 10px 10px;
        }
        .footer h3, .footer p {
            margin: 5px 0;
        }
        #dashboard a:hover {
             color: #f7b03e;
         }
    </style>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:wght@300&display=swap">
</head>
<body>
<header>
    <img id="logo1" src="https://upload.wikimedia.org/wikipedia/commons/5/51/IBM_logo.svg">
    <div id="dashboard">
        <a href="/dashboard">Dashboard</a>
    </div>
</header>
<div>
    <h2>Active Courses</h2>
    <ul>
        <c:forEach var="course" items="${courseList}">
            <li>${course} - Elapsed Time: ${elapsedTimeMap[course]}</li>
        </c:forEach>
    </ul>
    <form action="/startSession" method="post">
        <label for="courseName">Course Name:</label>
        <input type="text" id="courseName" name="courseName" value="${additionalCourse}" required>
        <input type="submit" value="Start Session">
    </form>
    <form action="/pauseSession" method="post">
        <label for="pauseCourse">Pause Session (choose course):</label>
        <select id="pauseCourse" name="courseName">
            <c:forEach var="course" items="${courseList}">
                <option value="${course}">${course}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Pause Session">
    </form>
    <form action="/resumeSession" method="post">
        <label for="resumeCourse">Resume Session (choose course):</label>
        <select id="resumeCourse" name="courseName">
            <c:forEach var="course" items="${courseList}">
                <option value="${course}">${course}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Resume Session">
    </form>
</div>
<footer>
    <div class ="footer">
        <h3>Follow Us</h3>
        <p>Stay connected with us on social media:</p>
    </div>
    <div class="home-sm">
        <a href="https://www.instagram.com/ibm/"><i class='bx bxl-instagram'></i></a>
        <a href="https://www.facebook.com/IBM/"><i class='bx bxl-facebook-circle'></i></a>
    </div>
</footer>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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
            font-family: 'IBM Plex Sans', sans-serif;
            margin: 0;
            padding: 0;
        }

        h2 {
            color: #132c33;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            background-color: #ffffff;
            margin: 5px 0;
            padding: 10px;
            border: 1px solid #d1d1d1;
            border-radius: 5px;
        }

        form {
            margin-top: 10px;
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

        footer {
            background-color: #0f75bc;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        #logo1 {
            width: 15%;
            height: 10%;
            display: block;
            margin: 20px auto;
            box-shadow: 0 0 20px rgb(255, 255, 255);
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
        <input type="text" id="courseName" name="courseName" required>
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
    <div>
        <h3>Follow Us</h3>
        <p>Stay connected with us on social media:</p>
        <ul>
            <li><a href="https://www.instagram.com/ibm/" target="_blank">Instagram</a></li>
            <li><a href="https://www.facebook.com/IBM/" target="_blank">Facebook</a></li>
        </ul>
    </div>
</footer>
</body>
</html>

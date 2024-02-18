<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Sessions</title>
    <style>
        body {
            background-color: #f4f7fc;
            font-family: 'IBM Plex Sans', sans-serif;
            margin: 0;
            padding: 0;
        }
        header, footer {
            background-color: #132c33;
            color: #ffffff;
            text-align: center;
            padding: 10px;
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
        input[type="text"], input[type="submit"] {
            padding: 5px;
            margin: 5px;
            border: 1px solid #132c33;
            border-radius: 3px;
        }
    </style>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:wght@300&display=swap">
</head>
<body>
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
<form action="/addCourse" method="post">
    <label for="newCourse">Add New Course:</label>
    <input type="text" id="newCourse" name="newCourse" required>
    <input type="submit" value="Add Course">
</form>
</body>
</html>

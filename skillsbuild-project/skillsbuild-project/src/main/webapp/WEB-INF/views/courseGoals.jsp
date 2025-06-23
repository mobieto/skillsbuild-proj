<%@ page import="java.util.List" %>
<%@ page import="com.example.group14project.domain.CourseComment" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Goals</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        header {
            padding: 10px;
            margin: 0;
            box-shadow: 0 5px 1px rgba(0, 0, 0, 0.2);
        }
        #dashboard {
            text-align: center;
            margin: 10px;
            text-decoration: none;
            color: inherit;
        }
        a {
            color: #0f75bc;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover{
            color:#f7b03e;
        }

        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            background-color: #0f75bc;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s ease;
            max-width: 140px;
        }

        .button:hover {
            background-color: #095d91;
        }

        .buttonContainer {
            display: flex;
            justify-content: space-around;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:wght@300&display=swap">
</head>
<body>
    <header>
        <div id="dashboard">
            <a href="/dashboard">Dashboard</a>
        </div>
    </header>
    <div class="container">
        <h1>Add a goal to your courses</h1>
        <div>
            <c:forEach var="course" items="${activeCourses}">
                <div>
                    <h2>${course.courseName}</h2>
                    <c:if test="${course.endGoal != null}">
                        <p>Your current goal is to finish the course before: ${course.getFormattedendGoal()}</p>
                    </c:if>
                    <div class="buttonContainer">
                        <a href="/addGoal?courseName=${course.courseName}&goal=2" class="button">15 Days (Bronze badge)</a>
                        <a href="/addGoal?courseName=${course.courseName}&goal=1" class="button">10 Days (Silver badge)</a>
                        <a href="/addGoal?courseName=${course.courseName}&goal=0" class="button">2 Days (Gold badge)</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>

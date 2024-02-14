<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Sessions</title>
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
</body>
</html>
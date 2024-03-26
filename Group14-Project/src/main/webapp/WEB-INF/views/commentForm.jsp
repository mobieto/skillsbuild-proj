<%@ page import="java.util.List" %>
<%@ page import="com.example.group14project.domain.CourseComment" %>
<%@ page import="com.example.group14project.domain.Course" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Comment</title>
    <link rel="stylesheet" href="/commentForm.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:wght@300&display=swap">
    <script>
        function validateForm() {
            var comment = document.getElementById("comment").value;
            if (comment.trim() === "") {
                document.getElementById("commentError").style.display = "block";
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<header>
    <img id="logo1" src="https://upload.wikimedia.org/wikipedia/commons/5/51/IBM_logo.svg">
    <div id="dashboard">
        <a href="/dashboard">Dashboard</a>
    </div>
</header>
<div class="container" >

    <h2 style="text-align: center;">Leave a Comment and Rating</h2>
    <div id="confirmationMessage" style="margin-top: 20px; text-align: center;">
    </div>

    <h3>Comments</h3>
    <div>
        <% for (CourseComment comment : (List<CourseComment>) request.getAttribute("submittedComments")) { %>
        <div class="comment-container">
            <div>
                <div class="name-text">
                    <p>Course Name: <%= comment.getCourseName() %></p>
                </div>
                <div class="rating-text">
                    <p>Rating: <%= comment.getRating() %></p>
                </div>
                <div class="comment-text">
                    <p>Comment: <%= comment.getComment() %></p>
                </div>
            </div>
        </div>
        <% } %>
    </div>

    <form id="commentForm" action="/comment" method="post" onsubmit="return validateForm()">
        <label for="courseName">Course Name:</label><br>
        <select id="courseName" name="courseName" required style="padding: 5px;" margin: auto;>
            <% for (Course course : (List<Course>) request.getAttribute("courses")) {
                if ("completed".equals(course.getStatus())) { %>
            <option value="<%= course.getName() %>"><%= course.getName() %></option>
            <% }
            } %>
        </select><br>
        <div style="margin-top: 23px;"></div>
        <label for="rating">Rating (1-5):</label><br>
        <input type="number" id="rating" name="rating" min="1" max="5" required><br>
        <div style="margin-top: 15px;"></div>
        <label for="comment">Comment:</label><br>
        <textarea id="comment" name="comment" rows="4" cols="50"></textarea><br>
        <div id="commentError" style="color: red; display: none;">Please enter a comment.</div>
        <input type="submit" value="Submit">
    </form>
</div>
<script src="/commentForm.js"></script>
</body>
</html>

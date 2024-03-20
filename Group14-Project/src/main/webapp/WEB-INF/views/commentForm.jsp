<%@ page import="java.util.List" %>
<%@ page import="com.example.group14project.domain.CourseComment" %>
<%@ page import="com.example.group14project.domain.Course" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course Comment</title>
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
        input[type="text"],
        input[type="number"],
        textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
            height: 100px;
        }
        input[type="submit"] {
            background-color: #0f75bc;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }
        input[type="submit"]:hover {
            background-color: #0f75bc;
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
        .comment-container {
            margin-bottom: 20px;
            border-bottom: 1px solid #ccc; /* Add a border to separate comments */
            padding-bottom: 10px;
        }
        .name-text {
            font-size: 16px;
            font-weight: bold;
        }
        .comment-text {
            font-size: 16px;
            margin-bottom: 5px;
        }
        .rating-text {
            font-size: 14px;
        }
        a {
            color: #0f75bc;
            text-decoration: none;
            font-weight: bold;
        }
        #logo1 {
            width: 15%;
            height: 10%;
            display: block;
            margin: 20px auto;
            box-shadow: 0 0 20px rgb(255, 255, 255);
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans:wght@300&display=swap">
</head>
<body>
<header>
    <img id="logo1" src="https://upload.wikimedia.org/wikipedia/commons/5/51/IBM_logo.svg">
    <div id="dashboard">
        <a href="/dashboard">Dashboard</a>
    </div>
</header>
<div class="container">
    <h2>Leave a Comment and Rating</h2>
    <div id="confirmationMessage" style="margin-top: 20px;">

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

    <form id="commentForm" action="/comment" method="post">
        <label for="courseName">Course Name:</label><br>
        <select id="courseName" name="courseName" required>
            <% for (Course course : (List<Course>) request.getAttribute("courses")) { %>
            <option value="<%= course.getName() %>"><%= course.getName() %></option>
            <% } %>
        </select><br>
        <label for="rating">Rating (1-5):</label><br>
        <input type="number" id="rating" name="rating" min="1" max="5" required><br>
        <label for="comment">Comment:</label><br>
        <textarea id="comment" name="comment" rows="4" cols="50"></textarea><br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>

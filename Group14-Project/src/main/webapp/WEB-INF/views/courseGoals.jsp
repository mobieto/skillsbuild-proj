<%@ page import="java.util.List" %>
<%@ page import="com.example.group14project.domain.CourseComment" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        a {
            color: #0f75bc;
            text-decoration: none;
            font-weight: bold;
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
        <h2>Add a goal to your courses</h2>
    </div>
</body>
</html>

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
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            float: right;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .confirmationMessage {
            margin-top: 20px;
        }
        .comment {
            border-bottom: 1px solid #ccc;
            padding-bottom: 10px;
            margin-bottom: 10px;
        }
        .comment h3 {
            margin-bottom: 5px;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#commentForm').submit(function(e) {
                e.preventDefault();

                var formData = $(this).serialize();

                $.post('/comment', formData, function(response) {
                    var newComment = '<div class="comment">';
                    newComment += '<h3>Course Name: ' + $('#courseName').val() + '</h3>';
                    newComment += '<p>Comment: ' + $('#comment').val() + '</p>';
                    newComment += '<p>Rating: ' + $('#rating').val() + '</p>';
                    newComment += '</div>';

                    $('#confirmationMessage').append(newComment);

                    $('#courseName').val('');
                    $('#rating').val('');
                    $('#comment').val('');

                    $('#confirmationMessage').show();
                });
            });
        });
    </script>
</head>
<body>
<div class="container">
    <h2>Leave a Comment and Rating</h2>
    <div id="confirmationMessage" style="margin-top: 20px;">

    </div>

    <form id="commentForm" method="post">
        <label for="courseName">Course Name:</label><br>
        <input type="text" id="courseName" name="courseName" required><br>
        <label for="rating">Rating (1-5):</label><br>
        <input type="number" id="rating" name="rating" min="1" max="5" required><br>
        <label for="comment">Comment:</label><br>
        <textarea id="comment" name="comment" rows="4" cols="50"></textarea><br>
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>

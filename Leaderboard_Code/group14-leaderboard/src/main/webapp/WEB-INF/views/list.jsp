<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Global Leaderboard</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Score</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.name}</td>
            <td>${player.score}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



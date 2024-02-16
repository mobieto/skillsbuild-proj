<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Global Leaderboard</title>
</head>
<body>
<h2>Global Leaderboard</h2>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }

    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    th {
        background-color: #f2f2f2;
    }
</style>
<table>
    <thead>
    <tr>
        <th>Rank</th>
        <th>Player Name</th>
        <th>Courses Completed</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="rank" value="1" />
    <c:forEach items="${players}" var="leaderboard">
        <c:forEach items="${leaderboard.getPlayers()}" var="player">
            <tr>
                <td>${rank}</td>
                <td>${player.name}</td>
                <td>${player.coursesCompleted}</td>
            </tr>
            <c:set var="rank" value="${rank + 1}" />
        </c:forEach>
    </c:forEach>
    </tbody>
</table>
<p><a href="/dashboard">Dashboard</a></p>
</body>
</html>





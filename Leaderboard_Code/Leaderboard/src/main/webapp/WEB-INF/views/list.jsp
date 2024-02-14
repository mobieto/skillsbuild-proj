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
        <th>Player ID</th>
        <th>Player Name</th>
        <th>Courses Completed</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${players}" var="leaderboard">
        <c:forEach items="${leaderboard.getPlayers()}" var="player">
            <tr>
                <td>${player.id}</td>
                <td>${player.name}</td>
                <td>${player.coursesCompleted}</td>
            </tr>
        </c:forEach>
    </c:forEach>
    </tbody>
</table>

</body>
</html>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<body>
<h2>Global Leaderboard</h2>
<link rel="stylesheet" href="/leaderboardCSS.css" />
<p><a href="/dashboard">Dashboard</a></p>
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
    <c:forEach items="${players}" var="player">
        <tr>
            <td>${rank}</td>
            <td>${player.name}</td>
            <td>${player.coursesCompleted}</td>
        </tr>
        <c:set var="rank" value="${rank + 1}" />
    </c:forEach>
    </tbody>
</table>
</body>
</html>






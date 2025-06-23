<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<link rel="stylesheet" href="/leaderboardCSS.css" />
<body>
<header>
    <img id="ibm-logo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/IBM_logo.svg/2560px-IBM_logo.svg.png">
    Global Leaderboard
</header>
<p>See how you stack up against the rest of the world!</p>
<p style="display: flex; flex-direction: row; gap: 3rem">
    <a href="/user">My Profile</a>
    <a href="/dashboard">Courses</a>
    <a href="/friends-leaderboard">Friends Leaderboard</a></p>

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






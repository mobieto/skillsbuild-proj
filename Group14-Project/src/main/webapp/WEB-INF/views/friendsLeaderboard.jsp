<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/leaderboardCSS.css" />
    <body>
        <header>
            <img id="ibm-logo" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/IBM_logo.svg/2560px-IBM_logo.svg.png">
            Friends Leaderboard
        </header>
        <p>See how you stack up against your friends!</p>
        <p style="display: flex; flex-direction: row; gap: 3rem">
            <a href="/user">My Profile</a>
            <a href="/dashboard">Courses</a>
            <a href="/leaderboard">Global Leaderboard</a></p>
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
        <c:choose>
            <c:when test="${players.size() <= 1}">
                <p style="margin-top: 1.2rem">Invite some friends and see who can reach rank 1!</p>
            </c:when>
        </c:choose>
    </body>
</html>
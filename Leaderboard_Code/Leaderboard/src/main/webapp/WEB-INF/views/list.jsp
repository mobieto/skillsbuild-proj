<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Global Leaderboard</title>
</head>
<body>
<h2>Global Leaderboard</h2>
<table>
    <thead>
    <tr>
        <th>Player Name</th>
        <th>Courses Completed</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="player" items="${players}">
        <tr>
            <td>${player.name}</td>
            <td>${player.coursesCompleted}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



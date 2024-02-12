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
        <th>Player ID</th>
        <th>Player Name</th>
        <th>Courses Completed</th>
    </tr>
    </thead>
</table>
<c:forEach items="${players}" var="player">
    <p>${player}</p>
</c:forEach>
</body>
</html>



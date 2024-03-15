<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<head>
    <title>User</title>
    <link rel="stylesheet" href="/dashboardCss.css"/>
    <link rel="stylesheet" href="/leaderboardCSS.css"/>
</head>
<body>
    <div id="top">
        <img src="/logo.png">
        <p>Welcome to the user page. Here you will find your stats and badges, along with other account info</p>
        <p><a href="/leaderboard">Global Leaderboard</a> <a href="/dashboard">Courses Dashboard</a></p>
    </div>
    <div class="center">
        <p>Username: ${user.name}</p>
        <p>Number of courses completed: ${user.coursesCompleted}</p>
        <table>
            <thead>
                <th>Badge</th>
                <th>Description</th>
            </thead>
            <c:forEach items="${badges}" var="badge">
                <tr>
                    <td>${badge.name}</td>
                    <td>${badge.description}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <h2>Add a friend</h2>
        <br>
        <form action="/sendFriendRequest" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <input type="submit" value="Add Friend">
        </form>
        <br>
        <p>${friendRequestResult}</p>
    </div>
</body>
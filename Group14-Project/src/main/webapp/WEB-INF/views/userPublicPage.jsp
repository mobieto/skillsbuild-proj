<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<head>
    <title>User</title>
    <link rel="stylesheet" href="/dashboardCss.css"/>
    <link rel="stylesheet" href="/leaderboardCss.css"/>
</head>

<body>
    <div id="top">
        <img src="/logo.png">
        <p>User profile</p>
        <p style="display: flex; flex-direction: row; gap: 3rem"><a href="/leaderboard">Global Leaderboard</a><a href="/dashboard">Courses Dashboard</a><a href="/friends-leaderboard">Friends Leaderboard</a></p>
    </div>

    <div class="center">
        <h3>Username: ${user.name}</h3>
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
        <div class="friend-list" style="margin-top: 3rem">
            <h3 style="margin-bottom: 0.5rem">Friends</h3>
            <ul>
                <c:forEach items="${user.getFriends()}" var="friend">
                    <li style="margin-bottom: 0.6rem">
                        <div style="display: flex; flex-direction: row; gap: 0.8rem">
                            <a href="/users/${friend.getName()}">${friend.getName()}</a>
                            <c:choose>
                                <c:when test="${
                                    !friend.getName().equals(principal.getName()) &&
                                    !commonFriends.contains(friend.getName())
                                }">
                                    <form action="/sendFriendRequest?username=${friend.getName()}" method="post">
                                        <input type="submit" value="Add friend">
                                    </form>
                                </c:when>
                                <c:when test="${friend.getName().equals(principal.getName())}"><p>(You)</p></c:when>
                                <c:otherwise>(Friend)</c:otherwise>
                            </c:choose>
                        </div>
                    </li>
                </c:forEach>
                <c:choose>
                    <c:when test="${user.getFriends().size() == 0}">
                        <li>Nothing here :(</li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</body>
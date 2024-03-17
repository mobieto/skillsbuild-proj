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
        <h3 style="margin-top: 3rem; margin-bottom: 0.5rem">Add a friend</h3>
        <form action="/sendFriendRequest" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <input type="submit" value="Add Friend">
        </form>
        <div class="friend-list" style="margin-top: 3rem">
            <h3 style="margin-bottom: 0.5rem">Your friends</h3>
            <ul>
                <c:forEach items="${user.getFriends()}" var="friend">
                    <li style="margin-bottom: 1rem">
                        <div style="display: flex; flex-direction: row; gap: 1rem">
                            <p>${friend.getName()}</p>
                            <form action="/removeFriend?username=${friend.getName()}" method="post">
                                <input type="submit" value="Unfriend">
                            </form>
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
        <h3 style="margin-top: 3rem; margin-bottom: 0.5rem">Friend requests</h3>
        <div class="friend-requests-list" style="display: flex; flex-direction: row; gap: 10rem;">
            <div style="display: flex; flex-direction: column">
                <h4>Incoming</h4>
                <br>
                <ul>
                    <c:forEach items="${user.getIncomingFriendRequests()}" var="friend">
                        <li style="margin-bottom: 1rem">
                            <div style="display: flex; flex-direction: row; gap: 1rem">
                                <p>${friend.getName()}</p>
                                <form action="/acceptFriendRequest?username=${friend.getName()}" method="post">
                                    <input type="submit" value="Accept">
                                </form>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div style="display: flex; flex-direction: column">
                <h4>Outgoing</h4>
                <br>
                <ul>
                    <c:forEach items="${user.getOutgoingFriendRequests()}" var="friend">
                        <li style="margin-bottom: 1rem">
                            <div style="display: flex; flex-direction: row; gap: 1rem">
                                <p>${friend.getName()}</p>
                                <form action="/removeFriendRequest?username=${friend.getName()}" method="post">
                                    <input type="submit" value="Remove">
                                </form>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>

        <p style="margin-top: 1rem; font-size: 0.8rem; color: #e03641;">
            ${friendRequestResult} ${removeFriendResult} ${acceptFriendRequestResult} ${removeFriendRequestResult}
        </p>
    </div>
</body>
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
        <p>Welcome to your profile. Here you will find your stats and badges, along with other account info</p>
        <p style="display: flex; flex-direction: row; gap: 3rem"><a href="/leaderboard">Global Leaderboard</a><a href="/dashboard">Courses</a><a href="/friends-leaderboard">Friends Leaderboard</a></p>
        <div class="P" style="text-align: center;">
            <h2>Course Completion Progress</h2>
        </div>
        <div class="progress" style="width: 75%;">
            <div class="progress-bar" style="width: ${percentage}%;"
                 aria-valuenow="${percentage}" aria-valuemin="0" aria-valuemax="100">
                <span style="visibility: hidden;">${percentage}%</span>
            </div>
        </div>
        <h3 style="text-align: center;
    font-family: Arial, sans-serif;
    color: #0f75bc;
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 10px;">${percentage}%</h3>
        <h9> Level: ${level}</h9>
        <h10> Exp: ${exp}</h10>

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
            <h3 style="margin-bottom: 0.5rem">Your friends</h3>
            <ul>
                <c:forEach items="${user.getFriends()}" var="friend">
                    <li style="margin-bottom: 0.6rem">
                        <div style="display: flex; flex-direction: row; gap: 0.8rem">
                            <a href="/users/${friend.getName()}">${friend.getName()}</a>
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
        <h3 style="margin-top: 3rem; margin-bottom: 0.5rem">Add a friend</h3>
        <form action="/sendFriendRequest" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <input type="submit" value="Add Friend">
        </form>
        <h3 style="margin-top: 3rem; margin-bottom: 0.5rem">Friend requests</h3>
        <div class="friend-requests-list" style="display: flex; flex-direction: row; gap: 10rem;">
            <div style="display: flex; flex-direction: column">
                <h4 style="margin-bottom: 0.6rem">Incoming</h4>
                <br>
                <ul>
                    <c:forEach items="${user.getIncomingFriendRequests()}" var="friend">
                        <li style="margin-bottom: 0.8rem">
                            <div style="display: flex; flex-direction: row; gap: 1rem">
                                <a href="/users/${friend.getName()}">${friend.getName()}</a>
                                <form action="/acceptFriendRequest?username=${friend.getName()}" method="post">
                                    <input type="submit" value="Accept">
                                </form>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <div style="display: flex; flex-direction: column">
                <h4 style="margin-bottom: 0.6rem">Outgoing</h4>
                <br>
                <ul>
                    <c:forEach items="${user.getOutgoingFriendRequests()}" var="friend">
                        <li style="margin-bottom: 0.8rem">
                            <div style="display: flex; flex-direction: row; gap: 1rem">
                                <a href="/users/${friend.getName()}">${friend.getName()}</a>
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
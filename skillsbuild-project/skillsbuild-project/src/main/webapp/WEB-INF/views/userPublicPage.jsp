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
        <p>User Profile</p>
        <p style="display: flex; flex-direction: row; gap: 3rem"><a href="/leaderboard">Global Leaderboard</a><a href="/user">My Profile</a><a href="/dashboard">Courses</a><a href="/friends-leaderboard">Friends Leaderboard</a></p>
    </div>

    <div class="center">
        <div style="display: flex; flex-direction: row; gap: 1rem">
            <h3>Username: ${user.getName()}</h3>
            <c:choose>
                <c:when test="${principalFriends.contains(user.getName())}">
                    <form action="/removeFriend?username=${user.getName()}&redirectTo=${user.getName()}" method="post">
                        <input type="submit" value="Unfriend">
                    </form>
                </c:when>

                <c:when test="${principalOutgoingRequests.contains(user.getName())}">
                    <form action="/removeFriendRequest?username=${user.getName()}&redirectTo=${user.getName()}" method="post">
                        <input type="submit" value="Remove Friend Request">
                    </form>
                </c:when>

                <c:when test="${principalIncomingRequests.contains(user.getName())}">
                    <form action="/acceptFriendRequest?username=${user.getName()}&redirectTo=${user.getName()}" method="post">
                        <input type="submit" value="Accept Friend Request">
                    </form>
                </c:when>

                <c:otherwise>
                    <form action="/sendFriendRequest?username=${user.getName()}&redirectTo=${user.getName()}" method="post">
                        <input type="submit" value="Add Friend">
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
        <p>Number of courses completed: ${user.coursesCompleted}</p>
        <table>
            <thead>
                <th>Badge</th>
                <th>Description</th>
            </thead>
            <c:forEach items="${badges}" var="badge">
                <tr>
                    <td>${badge.getName()}</td>
                    <td>${badge.getDescription()}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="friend-list" style="margin-top: 3rem">
            <h3 style="margin-bottom: 0.5rem">Friends</h3>
            <ul>
                <c:forEach items="${user.getFriends()}" var="friend">
                    <li style="margin-bottom: 0.6rem">
                        <div style="display: flex; flex-direction: row; gap: 0.8rem">
                            <c:choose>
                                <c:when test="${friend.getName().equals(principal.getName())}">
                                    <a href="/user">${friend.getName()}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/users/${friend.getName()}">${friend.getName()}</a>
                                </c:otherwise>
                            </c:choose>

                            <c:choose>
                                <c:when test="${
                                    !friend.getName().equals(principal.getName()) &&
                                    !principalFriends.contains(friend.getName()) &&
                                    !principalOutgoingRequests.contains(friend.getName()) &&
                                    !principalIncomingRequests.contains(friend.getName())
                                }">
                                    <form action="/sendFriendRequest?username=${friend.getName()}&redirectTo=${user.getName()}" method="post">
                                        <input type="submit" value="Add Friend">
                                    </form>
                                </c:when>

                                <c:when test="${principalFriends.contains(friend.getName())}">
                                    <form action="/removeFriend?username=${friend.getName()}&redirectTo=${user.getName()}" method="post">
                                        <input type="submit" value="Unfriend">
                                    </form>
                                </c:when>

                                <c:when test="${friend.getName().equals(principal.getName())}">
                                    <p>(You)</p>
                                </c:when>
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
        <p style="margin-top: 1rem; font-size: 0.8rem; color: #e03641;">
            ${friendRequestResult} ${removeFriendResult} ${acceptFriendRequestResult} ${removeFriendRequestResult}
        </p>
    </div>
</body>
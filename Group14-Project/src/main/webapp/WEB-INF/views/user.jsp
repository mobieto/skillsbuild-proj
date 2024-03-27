<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <title>User</title>
    <link rel="stylesheet" href="/userCss.css" />
    <script src="/userJs.js"></script>
</head>

<body>
    <div id="top">
        <img src="/logo.png">
        <p>Welcome to your profile. Here you will find your stats and badges, along with other account info</p>
        <p>
            <a href="/leaderboard">Global Leaderboard</a>
            <a href="/dashboard">Courses</a>
            <a href="/friends-leaderboard">Friends Leaderboard</a>
        </p>
    </div>
    <div class="P">
        <h2>Experience Points To Next Level</h2>
    </div>
    <div class="progress" style="width: 50%;">
        <div class="progress-bar" style="width: ${(exp % 500) / 5}%;"
             aria-valuenow="${(exp % 500) / 5}" aria-valuemin="0" aria-valuemax="100">
            <span style="visibility: hidden;">${exp % 500}</span>
        </div>
    </div>
    <h3 class="special">${exp % 500} / 500</h3>
    <div id="editform">
            <button id="editButton">Edit Profile</button>
            <button id="saveButton" style="display: none;">Save Changes</button>
    </div>
    <div class="center">
        <div class="profile-info">
            <div class="profile-image-container">
                <div id="imageContainer">
                    <img src="data:image/png;base64,${user.profilePictureBase64}" alt="Profile Image" id="profileImage">
                </div>
                <input type="file" name="profileImageFile" id="profileImageFile" style="display: none;">
            </div>
            <div class="user-info">
                <h3>${user.name}</h3>
                <p>Alias:
                    <span id="alias">${user.alias}</span>
                    <input id="aliasInput" value="${user.alias}">
                </p>
                <p>Number of courses completed: ${user.coursesCompleted}</p>
                <p>Level: ${level}</p>
                <p>D.O.B:
                    <span id="dob">${dob}</span>
                    <input id="dobInput" placeholder="${dob}">
                    <fmt:formatDate value="${user.dob}" pattern="dd MMMM yyyy" />

                </p>
                <p>Occupation:
                    <select id="occupation" name="occupation">
                        <option value="unemployed">Unemployed</option>
                        <option value="employed">Employed</option>
                        <option value="self-employed">Self-employed</option>
                        <option value="student">Student</option>
                        <option value="retired">Retired</option>
                    </select>

            </div>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Badge</th>
                    <th>Description</th>
                </tr>
            </thead>
            <c:forEach items="${badges}" var="badge">
                <tr>
                    <td>${badge.name}</td>
                    <td>${badge.description}</td>
                </tr>
            </c:forEach>
        </table>
        <div class="bio-section">
            <h3>Bio</h3>
            <p id="preBio">${user.bio}</p>
            <textarea id="bioInput" rows="4" cols="50">${user.bio}</textarea>
        </div>
        <div class="friend-list">
            <h3>Your friends</h3>
            <ul>
                <c:forEach items="${user.getFriends()}" var="friend">
                    <li>
                        <div  class="friend-list-sub">
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
        <h3 class="special2">Add a friend</h3>
        <form action="/sendFriendRequest" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <input type="submit" value="Add Friend">
        </form>
        <h3 class="special2">Friend requests</h3>
        <div class="friend-requests-list">
            <div id="special3">
                <h4>Incoming</h4>
                <br>
                <ul>
                    <c:forEach items="${user.getIncomingFriendRequests()}" var="friend">
                        <li>
                            <div class="special4">
                                <a href="/users/${friend.getName()}">${friend.getName()}</a>
                                <form action="/acceptFriendRequest?username=${friend.getName()}" method="post">
                                    <input type="submit" value="Accept">
                                </form>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="special5">
                <h4>Outgoing</h4>
                <br>
                <ul>
                    <c:forEach items="${user.getOutgoingFriendRequests()}" var="friend">
                        <li>
                            <div>
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



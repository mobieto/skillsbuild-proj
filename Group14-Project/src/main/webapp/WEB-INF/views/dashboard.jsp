<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <script src="scripts.js"></script>
    <title>Dashboard</title>
    <link rel="stylesheet" href="/dashboardCss.css" />
    <script src="https://kit.fontawesome.com/650125ee3f.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/x-icon" href="https://www.ibm.com/content/dam/adobe-cms/default-images/favicon.svg">
    <script src="/dashboardJs.js"></script>
</head>
<body>
<div id="top">
    <img src="/logo.png">
    <p>Welcome to the dashboard page. Here you will find all available IBM SkillsBuild courses for you to access and the categories they fall under.</p>
    <p style="display: flex; flex-direction: row; gap: 3rem">
        <a href="/leaderboard">Global Leaderboard</a>
        <a href="/user">My Profile</a>
        <a href="/friends-leaderboard">Friends Leaderboard</a>
        <a href="/comment">Comment</a></p>
</div>
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

<div id="container">
    <table id="dashboard">
        <thead>
        <tr>
            <th>
                <p>Course</p>
                <i class="fa-solid fa-sort-down" id="course_click"></i>
            </th>

            <th>
                <p>Category</p>
                <i class="fa-solid fa-sort" id="category_click"></i>
            </th>
            <th> <p>Timer</p></th>
            <th> <p>Progress</p></th>
            <th> <p>Complete</p></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>
                    <a href="${course.link}" id="courselink" target="_blank">${course.name}</a>
                </td>
                <td>
                        ${course.category}
                </td>
                <td><a href="/courses?newCourse=${course.name}" class="link2">Timer</a></td>
                <td><div class="mini-progress">
                    <div class="mini-progress-bar" style="width:${course.percentageCompleted}%;"></div>
                </div>
                        ${course.percentageCompleted}%
                </td>
                <td>
                    <a href="/completeCourse?courseName=${course.name}&courseStatus=${course.status}" class="link2">Complete</a>
                    <input type="hidden" name="courseStatus" value="${course.status}" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
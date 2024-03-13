<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
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
    <p><a href="/leaderboard">Global Leaderboard</a> <a href="/user">User Page</a> <a href="/friends-leaderboard">Friends Leaderboard</a></p>
</div>
<h2>All Courses</h2>
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
                <td><a href="/completeCourse" class="link2">Complete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<h3>Completed Courses</h3>
<div id="container2">
    <table id="dashboard2">
        <thead>
        <tr>
            <th>
                <p>Course</p>
            </th>

            <th>
                <p>Category</p>
            </th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>
</body>
</html>


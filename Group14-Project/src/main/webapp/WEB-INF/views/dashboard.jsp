<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/dashboardCss.css" />
    <script src="https://kit.fontawesome.com/650125ee3f.js" crossorigin="anonymous"></script>
    <script src="/dashboardJs.js"></script>
</head>
<body>
<div id="top">
    <img src="/logo.png">
    <p>Welcome to the dashboard page. Here you will find all available IBM SkillsBuild courses for you to access and the categories they fall under.</p>
    <p><a href="/leaderboard">Global Leaderboard</a></p>
</div>
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
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${courses}" var="course">
            <tr>
                <td>
                    <a href="#" id="courselink">${course.name}</a>
                </td>
                <td>
                        ${course.category}
                </td>
                <td>Start</td>
                <td><a href="/completeCourse">Complete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

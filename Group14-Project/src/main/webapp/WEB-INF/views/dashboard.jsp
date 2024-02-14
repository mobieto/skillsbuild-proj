<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        * {
            margin: 0;
            border: 0;
            box-sizing: border-box;
        }

        html {
            scroll-behavior: smooth;
        }

        #dashboard {
            border-collapse: collapse;
            border: 2px solid #8ACB88;
            margin-bottom: 20px;
            border-radius: 5px;
            width:70%;
        }

        #dashboard th, #dashboard td {
            text-align: left;
            padding: 8px;
        }

        #dashboard th {
            background-color: #648381;
            color: white;
            font-weight: bold;
        }

        #dashboard tr:nth-child(even) {
            background-color: #E4FDE1;
        }

        #dashboard tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<table id="dashboard">
    <tr>
        <th>Course</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td>
                <a href="${course.link}" target="_blank">${course.name}</a>
            </td>
            <td>
                    ${course.category}
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

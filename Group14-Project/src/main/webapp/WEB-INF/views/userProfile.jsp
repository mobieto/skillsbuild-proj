<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
<h2>Edit Profile</h2>
<form:form modelAttribute="user" action="${pageContext.request.contextPath}/user/saveEdit" method="post">
    <form:hidden path="id"/>
    <div>
        <form:label path="name">Name:</form:label>
        <form:input path="name" />
    </div>
    <div>
        <form:label path="email">Email:</form:label>
        <form:input path="email" />
    </div>
    <!-- Add other fields as needed -->
    <input type="submit" value="Save Changes"/>
</form:form>
</body>
</html>

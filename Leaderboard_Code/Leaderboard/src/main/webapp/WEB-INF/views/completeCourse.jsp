<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="/completeCourse" method="POST" modelAttribute="completeCourse">
    Player ID:
    <form:input path="playerId" required="true"/>
    <form:errors path="playerId"/>
    <input type="submit">
</form:form>


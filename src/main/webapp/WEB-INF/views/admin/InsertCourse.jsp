<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form action="/admin/services/pCourse" method="post" modelAttribute="newCourse">

        <label for="courseName">Course Name: </label>
        <form:select path="courseName">
            <form:options items="${courseNames}"/>
        </form:select>

        <%--<label for="courseLevel">Course Level: </label>--%>
        <%--<form:select path="courseLevel">--%>
            <%--<form:options items="${}"/>--%>
        <%--</form:select>--%>

        <label for="courseTitle">Course Title: </label>
        <form:textarea path="courseTitle" rows="5" cols="10"/>

        <label for="courseCredits">Course Units: </label>
        <form:input path="courseCredits"/>

        <label for="description">Course Description: </label>
        <form:textarea path="description" rows="10" cols="10"/>

        <input type="submit" value="Submit">
    </form:form>

</body>
</html>

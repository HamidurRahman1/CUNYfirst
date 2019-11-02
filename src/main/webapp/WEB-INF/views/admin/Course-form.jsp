<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Adding a Course</title>
</head>
<body>

    <%@include file="AdminName.jsp" %>
    <%@include file="../gen/RequiredField.jsp" %>

    <div class="add">
        <form:form action="${url}" method="${methodType}" modelAttribute="course">
            <label>* Course Name:</label>
            <form:select path="courseName" multiple="false">
                <form:options items="${courseNames}"/>
            </form:select><br><br>

            <label>* Course Level:</label>
            <form:select path="courseLevel" multiple="false">
                <form:options items="${courseLevels}"/>
            </form:select><br><br>

            <label>* Course Title:</label><br><br>
            <form:textarea path="courseTitle" rows="5" cols="30"/><br><br>

            <label>* Course Unit(s):</label>
            <form:select path="courseCredits" multiple="false">
                <form:options items="${courseCredits}"/>
            </form:select><br><br>

            <label>* Course Description:</label><br><br>
            <form:textarea path="description" rows="10" cols="30"/><br><br>

            <input type="submit" value="Submit"><br><br>
        </form:form>
    </div>

    <%@include file="BackToService.jsp" %>

</body>
</html>

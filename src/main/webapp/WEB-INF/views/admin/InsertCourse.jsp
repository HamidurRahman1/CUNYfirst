<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Adding a Course</title>
</head>
<body>

    <%@include file="AdminName.jsp" %>

    <div>
        <form:form action="/admin/services/insert/processed/course" method="post" modelAttribute="newCourse">
            * Course Name:
            <form:select path="courseName">
                <form:options items="${courseNames}"/>
            </form:select><br><br>

            <form:select path="courseLevel">
                <%--<form:options items="${}"/>--%>
            </form:select><br><br>

            * Course Title:<br><br>
            <form:textarea path="courseTitle" rows="5" cols="30"/><br><br>

            * Course Unit(s):
            <form:input path="courseCredits"/><br><br>

            * Course Description:<br><br>
            <form:textarea path="description" rows="10" cols="30"/><br><br>

            <%@include file="RequiredField.jsp" %>
            <br><br>

            <input type="submit" value="Submit"><br><br>
        </form:form>
    </div>

    <%@include file="BackToService.jsp" %>

</body>
</html>

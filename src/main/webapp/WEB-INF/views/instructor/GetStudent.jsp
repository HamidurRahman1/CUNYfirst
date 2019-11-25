
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Get Student ID</title>
</head>
<body>

    <%@include file="InstructorName.jsp"%>
    <%@include file="Logout.jsp"%>

    <form action="/instructor/get/getStudentCourse" method="get">
        <label>Student ID:</label>
        <input name="studentId" type="text" maxlength="8" minlength="1">
        <input type="submit" value="Submit">
    </form>

</body>
</html>

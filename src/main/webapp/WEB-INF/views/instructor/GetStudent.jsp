
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Get Student ID</title>
</head>
<body>

    <div><%@include file="InstructorName.jsp"%></div>
    <div><%@include file="Logout.jsp"%></div><br><br>

    <div>
        <form action="/instructor/get/getStudentCourse" method="get">
            <label>Student ID:</label>
            <input name="studentId" type="text" maxlength="8" minlength="1">
            <input type="submit" value="Submit">
        </form>
    </div>

    <div><%@include file="ServiceCenter.jsp"%></div>

</body>
</html>

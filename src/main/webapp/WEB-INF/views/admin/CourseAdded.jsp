
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Course has been added</title>
</head>
<body>

    <div><%@include file="AdminName.jsp" %></div>

    <div class="successful">
        <label>Course's Title:</label> ${course.courseTitle} <br><br>
        <label>Course's Name:</label> ${course.courseName} <br><br>
        <label>Course's Level:</label> ${course.courseLevel} <br><br>
        <label>Course's Units:</label> ${course.courseCredits} <br><br>
        <label>Course's Description:</label> ${course.description} <br><br>
    </div>

    <div><%@include file="ServiceCenter.jsp" %></div>

</body>
</html>

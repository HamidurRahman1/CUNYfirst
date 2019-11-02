
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Course has been added</title>
</head>
<body>

    <%@include file="AdminName.jsp" %>

    <div class="successful">
        <label>Course's Title:</label> ${course.courseTitle} <br><br>
        <label>Course's Name:</label> ${course.courseName} <br><br>
        <label>Course's Level:</label> ${course.courseLevel} <br><br>
        <label>Course's Units:</label> ${course.courseCredits} <br><br>
        <label>Course's Description:</label> ${course.description} <br><br>
    </div>

    <%@include file="ServiceCenter.jsp" %>

</body>
</html>

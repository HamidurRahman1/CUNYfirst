
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <div><%@include file="AdminName.jsp" %></div>

    <div class="successful">
        Course's Title: ${newCourse.courseCredits} <br><br>
        Course's Name: ${newCourse.courseName} <br><br>
        Course's Level: ${newCourse.courseLevel} <br><br>
        Course's Units: ${newCourse.courseCredits} <br><br>
        Course's Description: ${newCourse.description} <br><br>
        <br>
        <a href="/admin/services">Back to Services</a>
    </div>

</body>
</html>

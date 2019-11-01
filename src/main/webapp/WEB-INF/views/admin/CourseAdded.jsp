
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Course has been added</title>
</head>
<body>

    <%@include file="AdminName.jsp" %>

    <div class="successful">
        Course's Title: ${newCourse.courseCredits} <br><br>
        Course's Name: ${newCourse.courseName} <br><br>
        Course's Level: ${newCourse.courseLevel} <br><br>
        Course's Units: ${newCourse.courseCredits} <br><br>
        Course's Description: ${newCourse.description} <br><br>
        <br>
    </div>

    <%@include file="BackToService.jsp" %>

</body>
</html>

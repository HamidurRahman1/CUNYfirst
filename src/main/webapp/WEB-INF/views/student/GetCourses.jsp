
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>All Offered Courses</title>
</head>
<body>

    <div><%@include file="StudentNameID.jsp"%></div><br><br>

    <div><%@include file="Logout.jsp"%></div><br><br>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Offered Courses</h2></caption>
            <tr>
                <th>Course Name</th>
                <th>Course Level</th>
                <th>Course Title</th>
                <th>Course Units</th>
                <th>Course Description</th>
            </tr>

            <c:forEach var="course" items="${courses}">
                <tr>
                    <td>${course.courseName}</td>
                    <td>${course.courseLevel}</td>
                    <td>${course.courseTitle}</td>
                    <td>${course.courseCredits}</td>
                    <td>${course.description}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <br><br>

    <div><%@include file="BackToStudentCenter.jsp"%></div>

</body>
</html>

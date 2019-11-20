
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <div><%@include file="InstructorName.jsp"%></div>

    <div><%@include file="Logout.jsp"%></div>

    <div>
        <table border="1" cellpadding="5">
            <caption><h2>Courses</h2></caption>
            <tr>
                <th>Term</th>
                <th>Course</th>
            </tr>
            <c:forEach var="insCourse" items="${insCourses}">

                <tr>
                    <td>${insCourse.term.termName} ${insCourse.term.termYear}</td>
                    <td>${insCourse.course.courseName} ${insCourse.course.courseLevel}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div></div>

</body>
</html>

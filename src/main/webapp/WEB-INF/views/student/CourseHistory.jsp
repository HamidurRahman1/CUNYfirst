
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <div><%@include file="StudentNameID.jsp"%></div> <br>

    <div><%@include file="Logout.jsp"%></div><br><br>

    <br><br>

    <div class="courses">
        <table>
            <caption>All Courses</caption>
            <tr>
                <th>Subject</th>
                <th>Term</th>
                <th>Status</th>
                <th>Grade</th>
            </tr>

            <c:forEach var="studentCourse" items="${studentCourse}">
                <tr>
                    <td>${studentCourse.course.courseName} ${studentCourse.course.courseLevel}</td>
                    <td>${studentCourse.term.termName} ${studentCourse.term.termYear}</td>
                    <td>${studentCourse.courseStatus}</td>
                    <td>${studentCourse.grade}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <br><br>

    <div><%@include file="BackToStudentCenter.jsp"%></div>

</body>
</html>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <form:form>
        <table>
            <caption>Updateable Grades</caption>
            <tr>
                <th>Term</th>
                <th>Subject</th>
                <th>Student ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Grade</th>
            </tr>

            <c:forEach var="studentCourse"  items="${students}">
                <tr>
                    <td>${studentCourse.term.termName} ${studentCourse.term.termYear}</td>
                    <td>${studentCourse.course.courseName} ${studentCourse.course.courseLevel}</td>
                    <td>${studentCourse.student.studentId}</td>
                    <td>${studentCourse.student.firstName}</td>
                    <td>${studentCourse.student.lastName}</td>
                    <td><input type="text" value="${studentCourse.grade}"></td>
                </tr>
            </c:forEach>

        </table>
    </form:form>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <div>
        <form:form modelAttribute="studentCourse" action="/instructor/update/grades" method="post">

            <label>${studentCourse.student.studentId}</label>
            <label>${studentCourse.student.firstName} ${studentCourse.student.lastName}</label><br>
            <label>${studentCourse.course.courseName} ${studentCourse.course.courseLevel}</label><br>
            <form:select path="grade" items="${grades}"/>
            <input type="submit" value="Submit">
        </form:form>
    </div>

    <div><%@include file="ServiceCenter.jsp"%></div>

</body>
</html>

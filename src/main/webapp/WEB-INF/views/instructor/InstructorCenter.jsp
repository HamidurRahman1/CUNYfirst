
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <div>

        <div><%@include file="InstructorName.jsp"%></div>
        <%@include file="Logout.jsp"%>

        <div>
            <a href="/instructor/get/getCourses">Courses</a>
        </div>

        <div>
            <a href="/instructor/get/getStudentForm">Get Student</a>
        </div>

    </div>

</body>
</html>

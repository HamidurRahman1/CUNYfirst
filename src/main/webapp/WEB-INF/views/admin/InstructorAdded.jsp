
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
        <div><%@include file="AdminName.jsp" %></div>

        <div class="successful">
            Instructor's Name: ${newInstructor.firstName} ${newInstructor.lastName} <br><br>
            Instructor's ID: ${newInstructor.instructorId} <br><br>
            <%--Student's login username: ${newInstructor.login.username} <br><br>--%>
            <br>
            <a href="/admin/services">Back to Services</a>
        </div>
</body>
</html>

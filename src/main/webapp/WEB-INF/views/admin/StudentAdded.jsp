
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
            <div><%@include file="AdminName.jsp" %></div>

            <div class="successful">
                Student's Name: ${newStudent.firstName} ${newStudent.lastName} <br><br>
                Student's ID: ${newStudent.studentId} <br><br>
                Student's login username: ${newStudent.login.username} <br><br>

                <br>
                <a href="/admin/services">Back to Services</a>
            </div>
</body>
</html>

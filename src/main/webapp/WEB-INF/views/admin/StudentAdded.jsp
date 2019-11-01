
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Student has been added</title>
</head>
<body>
            <%@include file="AdminName.jsp" %>

            <div class="successful">
                Student's Name: ${newStudent.firstName} ${newStudent.lastName} <br><br>
                Student's ID: ${newStudent.studentId} <br><br>
                Student's login username: ${newStudent.login.username} <br><br>
            </div>

            <%@include file="BackToService.jsp" %>
</body>
</html>

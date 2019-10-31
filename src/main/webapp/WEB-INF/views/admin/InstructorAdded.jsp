
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
        <%@include file="AdminName.jsp" %>

        <div class="successful">
            Instructor's Name: ${newInstructor.firstName} ${newInstructor.lastName} <br><br>
            Instructor's ID: ${newInstructor.instructorId} <br><br>
        </div>

        <%@include file="BackToService.jsp" %>
</body>
</html>

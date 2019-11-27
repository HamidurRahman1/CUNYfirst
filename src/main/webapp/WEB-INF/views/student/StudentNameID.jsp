
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Student Name and ID</title>
</head>
<body>

    <div class="name">
        <br><br>
        <label>Student ID: </label> ${sessionScope.get("vStudent").getStudentId()}<br>
        <label>Name: </label> ${sessionScope.get("vStudent").getFirstName()} ${sessionScope.get("vStudent").getLastName()}
    </div>

</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@include file="AdminName.jsp" %>

    <div>
        <form action="/admin/services/displayStudent" method="get">
            Student ID: <input name="studentId" type="text" maxlength="8" minlength="8">
            <input type="submit" value="Get Student">
        </form>
    </div>

    <%@include file="BackToService.jsp" %>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Delete Student</title>
</head>
<body>

    <%@include file="AdminName.jsp" %>

    <c:choose>
        <c:when test="${not empty student}">
            <p>Are you sure you would like to delete student with ID: ${studentId}?<br>
                Everything will be deleted associated with this student.<br>
                To proceed deleting
                <form action="/admin/services/delete/deleted/student">
                    <input name="studentId" value="${studentId}" hidden>
                    <input type="submit" value="Click"></form>
                </form>
        </c:when>
        <c:otherwise>
            <p>No student found with the given student ID: ${studentId}</p>
        </c:otherwise>
    </c:choose>

    <%@include file="BackToService.jsp" %>

</body>
</html>

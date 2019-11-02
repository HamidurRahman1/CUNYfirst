<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="AdminName.jsp" %>

    <c:choose>
        <c:when test="${not empty object}">
            <p>Are you sure you would like to delete ${who} with ID: ${id}?<br>
                Everything will be deleted associated with this ${who}.<br>
                To proceed deleting
            <form action="${url}" method="${methodType}">
                <input name="id" value="${id}" hidden>
                <input type="submit" value="Click">
            </form>
        </c:when>
        <c:otherwise>
            <p>No ${who} found with the given ${who} ID: ${id}</p>
        </c:otherwise>
    </c:choose>

    <%@include file="ServiceCenter.jsp" %>
</body>
</html>

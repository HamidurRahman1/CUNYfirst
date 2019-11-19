
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>All Courses</title>
</head>
<body>

        <%@include file="AdminName.jsp" %>

        <jsp:include page="../generic/Courses.jsp" >
            <jsp:param name="courses" value="${courses}"/>
        </jsp:include>

        <%@include file="ServiceCenter.jsp" %>

</body>
</html>

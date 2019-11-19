
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>All Courses</title>
</head>
<body>

    <%@include file="StudentNameID.jsp"%>

    <jsp:include page="../generic/Courses.jsp" >
        <jsp:param name="courses" value="${courses}"/>
    </jsp:include>

    <%@include file="BackToStudentCenter.jsp"%>

</body>
</html>

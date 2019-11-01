
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@include file="AdminName.jsp"%>

    <jsp:include page="../gen/GetById.jsp" >
        <jsp:param name="url" value="${url}"/>
        <jsp:param name="methodType" value="${methodType}"/>
        <jsp:param name="displayWho" value="${displayWho}"/>
        <jsp:param name="inputId" value="${inputId}"/>
        <jsp:param name="max" value="${max}"/>
        <jsp:param name="min" value="${min}"/>
        <jsp:param name="submitText" value="${submitText}"/>
    </jsp:include>

    <%@include file="BackToService.jsp"%>

</body>
</html>

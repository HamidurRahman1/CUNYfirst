
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>${title}</title>
</head>
<body>
    <%@include file="../admin/AdminName.jsp"%>
    <div class="message">
        <h3>${message}<h3>
    </div>
    <%@include file="../admin/BackToService.jsp"%>
</body>
</html>

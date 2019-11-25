
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>${title}</title>
</head>
<body>
    <jsp:include page="${name}" flush="true" />
    <div class="message"><h3>${message}</h3></div>
    <jsp:include page="${serviceCenter}" flush="true"/>
</body>
</html>

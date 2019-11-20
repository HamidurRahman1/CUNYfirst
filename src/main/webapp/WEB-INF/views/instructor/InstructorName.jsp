
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="name-section">
    <h4>Instructor: ${sessionScope.get("instructor").getFirstName()} ${sessionScope.get("instructor").getLastName()} </h4>
</div>

</body>
</html>

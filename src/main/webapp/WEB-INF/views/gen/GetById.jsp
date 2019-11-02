
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Get By ID</title>
</head>
<body>

    <div class="generic-get">
        <form action="${param.url}" method="${param.methodType}">
            <label>${param.displayWho}</label>
            <input name="${param.inputId}" type="text" maxlength="${param.max}" minlength="${param.min}">
            <input type="submit" value="${param.submitText}">
        </form>
    </div>

</body>
</html>

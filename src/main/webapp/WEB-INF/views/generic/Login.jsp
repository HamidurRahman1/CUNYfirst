
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>${title} Login</title>
</head>
<body>
    <form:form action="${url}" method="${methodType}" modelAttribute="login">
        <label for="username">Username</label><form:input path="username"/>
        <br><br>
        <label for="password">Password</label><form:password path="password"/>
        <br><br>
        <input value="Submit" type="submit">
    </form:form>

    <div><a href="/index.jsp">Home</a></div>
</body>
</html>

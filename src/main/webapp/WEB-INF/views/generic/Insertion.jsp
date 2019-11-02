
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <%@include file="../admin/AdminName.jsp"%>

    <div class="successful">
        <label>${who}'s Name: </label>
        <label>${firstName} ${lastName}</label><br><br>

        <label>${who}'s ID: </label>
        <label>${id} </label><br><br>

        <label>${who}'s login username: </label>
        <label>${username}</label><br><br>
    </div>

    <%@include file="../admin/ServiceCenter.jsp"%>

</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Adding a Instructor</title>
</head>
<body>

    <%@include file="AdminName.jsp"%>
    <%@include file="../generic/RequiredField.jsp"%>

    <div class="add">
        <strong>Instructor's Personal Information</strong><br><br>
        <form:form modelAttribute="instructor" action="${url}" method="${methodType}">
            <label for="firstName">* First Name: </label><form:input type="text" path="firstName"/>
            <br><br>
            <label for="lastName">* Last Name: </label><form:input type="text" path="lastName"/>
            <br><br>
            <label for="ssn">* SSN: </label><form:input type="number" path="ssn"/>
            <br><br>
            <label for="dateOfBirth">* Date of Birth: </label><form:input type="text" path="dateOfBirth"/>
            <br><br>
            <label for="gender">* Gender: </label><form:radiobuttons path="gender" items="${genders}"/>
            <br><br><br>
            <input value="Submit" type="submit">
        </form:form>
    </div>

    <%@include file="ServiceCenter.jsp" %>

</body>
</html>

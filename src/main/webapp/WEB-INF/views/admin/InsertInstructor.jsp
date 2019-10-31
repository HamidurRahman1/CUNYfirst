<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <div><%@include file="AdminName.jsp" %></div>

    <form:form modelAttribute="newInstructor" action="/admin/services/pInstructor" method="post">

        <strong>Instructor Personal Information</strong><br><br>
        <label for="firstName">* First Name: </label><form:input type="text" path="firstName"/>
        <br><br>
        <label for="lastName">* Last Name: </label><form:input type="text" path="lastName"/>
        <br><br>
        <label for="ssn">* SSN: </label><form:input type="number" path="ssn"/>
        <br><br>
        <label for="dateOfBirth">* Date of Birth: </label><form:input type="date" path="dateOfBirth"/>
        <br><br>
        <label for="gender">* Gender: </label><form:radiobuttons path="gender" items="${genders}"/>
        <br><br><br>

        <input value="Submit" type="submit">
    </form:form>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>FAFSA's</title>
</head>
<body>

    <%@include file="StudentNameID.jsp"%>

    <div class="fafsas">
        <table border="1" cellpadding="5">
            <caption><h2>Student's FAFSA</h2></caption>
            <tr>
                <th>Term</th>
                <th>Amount $</th>
            </tr>

            <c:forEach var="fafsa" items="${fafsas}">
                <tr>
                    <td>${fafsa.term.termName} ${fafsa.term.termYear}</td>
                    <td>${fafsa.amount}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <%@include file="BackToStudentCenter.jsp"%>
</body>
</html>

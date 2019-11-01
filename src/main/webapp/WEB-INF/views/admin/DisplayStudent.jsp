<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Student's Information</title>
</head>
<body>

    <%@include file="AdminName.jsp" %>

    <div class="student-display">
        <table border="1" cellpadding="5">
            <caption><h2>Student's Personal Information</h2></caption>
            <tr>
                <th>Student Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>SSN</th>
                <th>Date of Birth</th>
                <th>Gender</th>
            </tr>
            <tr>
                <td>${student.studentId}</td>
                <td>${student.firstName}</td>
                <td>${student.lastName}</td>
                <td>${student.ssn}</td>
                <td>${student.dateOfBirth}</td>
                <td>${student.gender}</td>
            </tr>
        </table>
    </div>

    <div class="student-display">
        <table border="1" cellpadding="5">
            <caption><h2>Student's Login Information</h2></caption>
            <tr>
                <th>Username</th>
                <th>Active</th>
            </tr>
            <tr>
                <td>${student.login.username}</td>
                <td>${student.login.active}</td>
            </tr>
        </table>
    </div>

    <div class="student-display">
        <table border="1" cellpadding="5">
            <caption><h2>Student's Address Information</h2></caption>
            <tr>
                <th>Street</th>
                <th>Cross Street</th>
                <th>City</th>
                <th>State</th>
                <th>Zip code</th>
            </tr>
            <tr>
                <td>${student.address.street}</td>
                <td>${student.address.crossStreet}</td>
                <td>${student.address.city}</td>
                <td>${student.address.state}</td>
                <td>${student.address.zipCode}</td>
            </tr>
        </table>
    </div>

    <div class="student-display">
        <table border="1" cellpadding="5">
            <caption><h2>Student's Contact Information</h2></caption>
            <tr>
                <th>Personal Email</th>
                <th>College Email</th>
                <th>Phone</th>
            </tr>
            <tr>
                <td>${student.contact.email}</td>
                <td>${student.contact.collegeEmail}</td>
                <td>${student.contact.phone}</td>
            </tr>
        </table>
    </div>

    <div class="student-display">
        <table border="1" cellpadding="5">
            <caption><h2>Student's High School Information</h2></caption>
            <tr>
                <th>High School Name</th>
                <th>Year</th>
                <th>City</th>
                <th>Country</th>
            </tr>
            <tr>
                <td>${student.highSchoolInfo.highSchoolName}</td>
                <td>${student.highSchoolInfo.year}</td>
                <td>${student.highSchoolInfo.city}</td>
                <td>${student.highSchoolInfo.country}</td>
            </tr>
        </table>
    </div>

    <div class="student-display">
        <table border="1" cellpadding="5">
            <caption><h2>Student's Transfer Information</h2></caption>
            <tr>
                <th>School Name</th>
                <th>Term</th>
            </tr>
            <tr>
                <td>${student.transferInfo.transferSchoolName}</td>
                <td>${student.transferInfo.term.termName} ${student.transferInfo.term.termYear}</td>
            </tr>
        </table>
    </div>

    <div class="student-display">
        <table border="1" cellpadding="5">
            <caption><h2>Student's Security Questions</h2></caption>
            <tr>
                <th>Security Questions</th>
            </tr>
            <c:forEach var="question" items="${student.questionsAns.keySet()}">
                <tr><td>${question}</td></tr>
            </c:forEach>
        </table>
    </div>

    <div class="student-display">
        <table border="1" cellpadding="5">
            <caption><h2>Student's FAFSA</h2></caption>
            <tr>
                <th>Term</th>
                <th>Amount $</th>
            </tr>

            <c:forEach var="fafsa" items="${student.fafsas}">
                <tr>
                    <td>${fafsa.term.termName} ${fafsa.term.termYear}</td>
                    <td>${fafsa.amount}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <div class="student-display">
        <table  border="1" cellpadding="5">
            <caption><h2>Student's Courses</h2></caption>
            <tr>
                <th>Course</th>
                <th>Term</th>
                <th>Grade</th>
                <th>Status</th>
            </tr>
            <c:forEach var="studentCourse" items="${student.studentCourses}">
                <tr>
                    <td>${studentCourse.course.courseName} ${studentCourse.course.courseLevel}</td>
                    <td>${studentCourse.term.termName} ${studentCourse.term.termYear}</td>
                    <td>${studentCourse.grade}</td>
                    <td>${studentCourse.courseStatus}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br><br>

    <%@include file="BackToService.jsp" %>
</body>
</html>

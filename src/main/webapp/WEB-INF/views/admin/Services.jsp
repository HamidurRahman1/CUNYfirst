
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Admin Services</title>
</head>
<body>

        <%@include file="AdminName.jsp" %>

        <div id="adminStudentServices">
            <h3>Student Services</h3>
            <ul>
                <li><a href="/admin/services/getStudent">Get Student</a></li>
                <li><a href="/admin/services/insertStudent">Insert Student</a></li>
                <li><a href="">Update Student</a></li>
            </ul>
        </div>

        <div id="adminInstructorServices">
            <h3>Instructor Services</h3>
            <ul>
                <li><a href="/admin/services/insertInstructor">Insert Instructor</a></li>
                <li>Delete an Instructor</li>
            </ul>
        </div>

        <div id="adminCourseServices">
            <h3>Course Services</h3>
            <ul>
                <li><a href="/admin/services/insertCourse">Insert a Course</a></li>
                <li><a href="/admin/services/getCourses">Get Courses</a></li>
            </ul>
        </div>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<html>
<head>
    <title>Admin Service Center</title>
</head>
<body>

        <%@include file="AdminName.jsp"%>

        <div id="adminStudentServices">
            <h3>Student Services</h3>
            <ul>
                <li><a href="/admin/services/get/getStudent">Get a Student</a></li>
                <li><a href="/admin/services/insert/student">Insert a Student</a></li>
                <li><a href="/admin/services/update/getStudent">Update a Student</a></li>
                <li><a href="/admin/services/delete/getStudent">Delete a Student</a></li>
            </ul>
        </div>

        <div id="adminInstructorServices">
            <h3>Instructor Services</h3>
            <ul>
                <li><a href="/admin/services/insert/instructor">Insert an Instructor</a></li>
                <li><a href="/admin/services/update/getInstructor">Update an Instructor</a></li>
                <li><a href="/admin/services/delete/getInstructor">Delete an Instructor</a></li>
            </ul>
        </div>

        <div id="adminCourseServices">
            <h3>Course Services</h3>
            <ul>
                <li><a href="/admin/services/insert/course">Insert a Course</a></li>
                <li><a href="/admin/services/get/getCourses">Get Courses</a></li>
            </ul>
        </div>
</body>
</html>

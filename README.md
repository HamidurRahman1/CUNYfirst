# CUNYfirst
<p>
    <h2>Objectives</h2>
        <h4>Build a School based application with different kind of portals to demonstrate
    the usage of the following tools - </h4>
    <ul>
        <li>A complete CRUD application</li>
        <li>Usage of Spring framework
            <ul>
                <li>Spring IoC</li>
                <li>Spring DI</li>
                <li>Spring MVC</li>
                <li>Spring Web</li>
            </ul>
        </li>
        <li>Hibernate for database</li>
        <li>Retrieve resources from database as per request instead of a bulk request</li>
        <li>Usage of external properties files</li>
        <li>Separting the view and business logic</li>
    </ul>
</p>

<p>
    <h2>This application has three parts</h2>
    <ul>
        <li><strong>Admin</strong>
            <ul>
                <li>An admin can insert a new student</li>
                <li>An admin can update a student</li>
                <li>An admin can view a students record</li>
                <li>An admin can delete a student without deleting FAFSA records 
                (one important business logic) and the courses</li>
                <li>An admin can insert a new instructor</li>
                <li>An admin can update an existing instructor</li>
                <li>An admin can delete an instructor without deleting the courses and the students</li>
                <li>An admin can view all courses</li>
            </ul>
         </li>   
        <li><strong>Student</strong>
            <ul>
                <li>A student can view all it's relevant information</li>
                <li>Not all of the information is loaded when a student's logged in like 
                Course histories and Financial Activities</li>
                <li>A student cannot modify it's own record, only doable by an admin</li>
            </ul>
         </li> 
        <li><strong>Instructor</strong>
            <ul>
                <li>An instructor can update any student that is enrolled in his/her class
                in this term</li>
            </ul>
        </li>
    </ul>
</p>

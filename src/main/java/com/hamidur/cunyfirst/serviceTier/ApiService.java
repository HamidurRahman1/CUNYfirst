package com.hamidur.cunyfirst.serviceTier;

import com.hamidur.cunyfirst.daoTier.daoServices.AdminService;
import com.hamidur.cunyfirst.daoTier.daoServices.CourseService;
import com.hamidur.cunyfirst.daoTier.daoServices.InstructorService;
import com.hamidur.cunyfirst.daoTier.daoServices.StudentService;
import com.hamidur.cunyfirst.daoTier.util.Utility;
import com.hamidur.cunyfirst.viewTier.models.Course;
import com.hamidur.cunyfirst.viewTier.models.Instructor;
import com.hamidur.cunyfirst.viewTier.models.Student;
import org.springframework.stereotype.Service;

@Service
public class ApiService
{
    private final StudentService studentService;
    private final InstructorService instructorService;
    private final CourseService courseService;
    private final AdminService adminService;

    public ApiService(final StudentService studentService, final InstructorService instructorService,
                      final CourseService courseService, final AdminService adminService)
    {
        this.studentService = studentService;
        this.instructorService = instructorService;
        this.courseService = courseService;
        this.adminService = adminService;
    }

    public Integer insertStudent(Student student)
    {
        if(student == null) throw new IllegalArgumentException("Student cannot be null");
        else if(student.getAddress() == null) throw new IllegalArgumentException("Address cannot be null");
        else if(student.getContact() == null) throw new IllegalArgumentException("Contact cannot be null");
        else if(student.getHighSchoolInfo() == null) throw new IllegalArgumentException("High School Info must be provided");

        return studentService.insertStudent(Utility.toDaoStudent(student));
    }

    public boolean insertCourse(Course course)
    {

    }

    public Integer insertInstructor(Instructor instructor)
    {
        return instructorService.insertInstructor(instructor);
    }
}

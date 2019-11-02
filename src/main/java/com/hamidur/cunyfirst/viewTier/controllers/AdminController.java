package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.viewTier.ViewRelatedTester;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Course;
import com.hamidur.cunyfirst.viewTier.models.Instructor;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.PropertyHandler;
import com.hamidur.cunyfirst.viewTier.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private PropertyHandler propertyHandler;

    @GetMapping("/login")
    public String studentLogin(Model model)
    {
        model.addAttribute("login", new Login());
        return "admin/Login";
    }

    @PostMapping("/processAdminLogin")
    public String processLogin(@ModelAttribute("login") Login login, HttpSession session)
    {
        Admin admin = ViewRelatedTester.testAdmin();
        session.setAttribute("admin", admin);
        return "redirect:/admin/services";
    }

    @GetMapping("/services")
    public String services()
    {
        return "admin/Services";
    }

    @GetMapping("/services/get/getStudent")
    public String getStudent(Model model)
    {
        model.addAttribute("url", "/admin/services/display/student");
        model.addAttribute("methodType", propertyHandler.GET);
        model.addAttribute("inputId", propertyHandler.INP_STUDENT_ID);
        model.addAttribute("displayWho", propertyHandler.DIS_STUDENT_ID);
        model.addAttribute("max", 8);
        model.addAttribute("min", 8);
        return "admin/GetStudent";
    }

    @GetMapping("/services/get/getCourses")
    public String getCourses(Model model)
    {
        List<Course> courses = ViewRelatedTester.demoCourses();
        model.addAttribute("courses", courses);
        return "admin/GetCourses";
    }

    @GetMapping("/services/display/student")
    public String displayStudent(@RequestParam("studentId") Integer studentId, Model model)
    {
        Student student = ViewRelatedTester.testStudent();
        model.addAttribute("student", student);
        return "admin/DisplayStudent";
    }

    @GetMapping("/services/insert/student")
    public String insertStudent(Model model)
    {
        try
        {
            model.addAttribute("url", "/admin/services/insert/processed/student");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("student", new Student());
            model.addAttribute("genders", propertyHandler.getGenders());
            model.addAttribute("states", propertyHandler.getStates());
            model.addAttribute("countries", propertyHandler.getCountries());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "admin/Student-form";
    }

    @PostMapping("/services/insert/processed/student")
    public String processNewStudent(@ModelAttribute("student") Student student, Model model)
    {
        student.setStudentId(10000001);
        model.addAttribute("student", student);
        model.addAttribute("who", "Student");
        model.addAttribute("firstName", student.getFirstName());
        model.addAttribute("lastName", student.getLastName());
        model.addAttribute("username", student.getLogin().getUsername());
        model.addAttribute("id", student.getStudentId());
        return "gen/Insertion";
    }

    @GetMapping("/services/update/getStudent")
    public String updateStudent(Model model)
    {
        model.addAttribute("url", "/admin/services/update/updateable/student");
        model.addAttribute("methodType", propertyHandler.GET);
        model.addAttribute("inputId", propertyHandler.INP_STUDENT_ID);
        model.addAttribute("displayWho", propertyHandler.DIS_STUDENT_ID);
        model.addAttribute("max", 8);
        model.addAttribute("min", 8);
        return "admin/GetStudent";
    }

    @GetMapping("/services/update/updateable/student")
    public String updateableStudent(@RequestParam("studentId") Integer studentId, Model model)
    {
        try
        {
            model.addAttribute("url", "/admin/services/update/updated/student");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("student", ViewRelatedTester.testStudent());
            model.addAttribute("genders", propertyHandler.getGenders());
            model.addAttribute("states", propertyHandler.getStates());
            model.addAttribute("countries", propertyHandler.getCountries());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "admin/Student-form";
    }

    @PostMapping("/services/update/updated/student")
    public String updatesStudent(@ModelAttribute("student") Student student, Model model)
    {
        model.addAttribute("title", "Student Updated");
        model.addAttribute("message", "Student has been successfully updated.");
        return "gen/Message";
    }

    @GetMapping("/services/delete/getStudent")
    public String deleteStudent(Model model)
    {
        model.addAttribute("url", "/admin/services/delete/deletable/student");
        model.addAttribute("methodType", propertyHandler.GET);
        model.addAttribute("inputId", propertyHandler.INP_STUDENT_ID);
        model.addAttribute("displayWho", propertyHandler.DIS_STUDENT_ID);
        model.addAttribute("max", 8);
        model.addAttribute("min", 8);
        return "admin/GetStudent";
    }

    @GetMapping("/services/delete/deletable/student")
    public String deletableStudent(@RequestParam("studentId") Integer studentId, Model model)
    {
        try
        {
            model.addAttribute("studentId", studentId);
            model.addAttribute("url", "/admin/services/delete/deleted/student");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("student", ViewRelatedTester.testStudent());
            model.addAttribute("genders", propertyHandler.getGenders());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "admin/DeletableStudent";
    }

    @GetMapping("/services/delete/deleted/student")
    public String studentDeleted(@RequestParam("studentId") Integer studentId, Model model)
    {
        System.out.println(studentId);
        model.addAttribute("title", "Student deleted");
        model.addAttribute("message", "Student has been successfully deleted.");
        return "gen/Message";
    }

    @GetMapping("/services/insert/instructor")
    public String insertInstructor(Model model)
    {
        try
        {
            model.addAttribute("instructor", new Instructor());
            model.addAttribute("url", "/admin/services/insert/processed/instructor");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("genders", propertyHandler.getGenders());
        }
        catch (IOException ex)
        {
            // redirect
            System.out.println(ex.getMessage());
        }
        return "admin/Instructor-form";
    }

    @PostMapping("/services/insert/processed/instructor")
    public String processNewInstructor(@ModelAttribute("instructor") Instructor instructor, Model model)
    {
        instructor.setInstructorId(1001);
        instructor.setLogin(new Login("username.edu", "pass"));
        model.addAttribute("who", "Instructor");
        model.addAttribute("firstName", instructor.getFirstName());
        model.addAttribute("lastName", instructor.getLastName());
        model.addAttribute("username", instructor.getLogin().getUsername());
        model.addAttribute("id", instructor.getInstructorId());
        return "gen/Insertion";
    }

    @GetMapping("/services/update/getInstructor")
    public String getInstructor(Model model)
    {
        model.addAttribute("url", "/admin/services/update/updateable/instructor");
        model.addAttribute("methodType", propertyHandler.GET);
        model.addAttribute("inputId", propertyHandler.INP_INSTRUCTOR_ID);
        model.addAttribute("displayWho", propertyHandler.DIS_INSTRUCTOR_ID);
        model.addAttribute("max", 3);
        model.addAttribute("min", 3);
        return "admin/GetInstructor";
    }

    @GetMapping("/services/update/updateable/instructor")
    public String updateableInstructor(@RequestParam("instructorId") Integer instructorId, Model model)
    {
        try
        {
            model.addAttribute("url", "/admin/services/update/updated/instructor");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("instructor", ViewRelatedTester.testInstructor());
            model.addAttribute("genders", propertyHandler.getGenders());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "admin/Instructor-form";
    }

    @PostMapping("/services/update/updated/instructor")
    public String updatedInstructor(@ModelAttribute("instructor") Instructor instructor, Model model)
    {
        model.addAttribute("title", "Instructor Updated");
        model.addAttribute("message", "Instructor has been successfully updated.");
        return "gen/Message";
    }

    @GetMapping("/services/insert/course")
    public String insertCourse(Model model)
    {
        try
        {
            model.addAttribute("url", "/admin/services/insert/processed/course");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("course", new Course());
            model.addAttribute("courseNames", propertyHandler.getCourseNames());
            model.addAttribute("courseLevels", propertyHandler.getCourseLevels());
            model.addAttribute("courseCredits", propertyHandler.getCourseCredits());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "admin/Course-form";
    }

    @PostMapping("/services/insert/processed/course")
    public String processCourse(@ModelAttribute("course")Course course, Model model)
    {
        System.out.println(course);
        course.setCourseId(101);
        model.addAttribute("course", course);
        return "admin/CourseAdded";
    }
}

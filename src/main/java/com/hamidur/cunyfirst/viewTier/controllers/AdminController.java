package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.serviceTier.ApiService;
import com.hamidur.cunyfirst.viewTier.ViewRelatedTester;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Course;
import com.hamidur.cunyfirst.viewTier.models.Instructor;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.PropertyHandler;
import com.hamidur.cunyfirst.viewTier.models.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    private final ApplicationContext applicationContext;
    private final ApiService apiService;
    private final PropertyHandler propertyHandler;

    public AdminController(@Autowired final ApplicationContext applicationContext,
                           @Autowired final ApiService apiService,
                           @Autowired final PropertyHandler propertyHandler)
    {
        this.applicationContext = applicationContext;
        this.apiService = apiService;
        this.propertyHandler = propertyHandler;
    }

    @GetMapping("/login")
    public String studentLogin(Model model)
    {
        model.addAttribute("login", new Login());
        model.addAttribute("title", "Admin");
        model.addAttribute("url", "/admin/processAdminLogin");
        model.addAttribute("methodType", propertyHandler.POST);
        return "generic/Login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute("admin");
        return "redirect:/admin/login";
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

    @GetMapping("/services/display/student")
    public String displayStudent(@RequestParam("studentId") Integer studentId, Model model)
    {
        try
        {
            model.addAttribute("student", apiService.getStudentById(studentId));
            return "admin/DisplayStudent";
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return "redirect:/admin/services/get/getStudent";
        }
    }

    @GetMapping("/services/insert/student")
    public String insertStudent(Model model)
    {
        try
        {
            model.addAttribute("url", "/admin/services/insert/processed/student");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("student", applicationContext.getBean(Student.class));
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
    public String processNewStudent(@ModelAttribute("student") Student student1, Model model)
    {
        try
        {
            student1 = apiService.insertStudent(student1);
            model.addAttribute("student", student1);
            model.addAttribute("who", "Student");
            model.addAttribute("firstName", student1.getFirstName());
            model.addAttribute("lastName", student1.getLastName());
            model.addAttribute("username", student1.getLogin().getUsername());
            model.addAttribute("id", student1.getStudentId());
            return "generic/Insertion";
        }
        catch(IllegalArgumentException ex) {
            return "admin/Student-form";
        }
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
        model.addAttribute("name", "../admin/AdminName.jsp");
        model.addAttribute("serviceCenter", "../admin/ServiceCenter.jsp");

        model.addAttribute("title", "Student Updated");
        model.addAttribute("message", "Student with ID: "+student.getStudentId()
                +" has been successfully updated.");
        return "generic/Message";
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
        model.addAttribute("who", propertyHandler.STUDENT.toLowerCase());
        model.addAttribute("id", ViewRelatedTester.testStudent().getStudentId());
        model.addAttribute("url", "/admin/services/delete/deleted/student");
        model.addAttribute("methodType", propertyHandler.GET);
        model.addAttribute("object", ViewRelatedTester.testStudent());
        return "admin/Deletable";
    }

    @GetMapping("/services/delete/deleted/student")
    public String studentDeleted(@RequestParam("id") Integer studentId, Model model)
    {
        model.addAttribute("name", "../admin/AdminName.jsp");
        model.addAttribute("serviceCenter", "../admin/ServiceCenter.jsp");

        model.addAttribute("title", "Student deleted");
        model.addAttribute("message", "Student with ID: " + studentId
                + " has been successfully deleted.");
        return "generic/Message";
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
        try
        {
            Instructor instructor1 = apiService.insertInstructor(instructor);
            model.addAttribute("who", "Instructor");
            model.addAttribute("firstName", instructor1.getFirstName());
            model.addAttribute("lastName", instructor1.getLastName());
            model.addAttribute("username", instructor1.getLogin().getUsername());
            model.addAttribute("id", instructor1.getInstructorId());
            return "generic/Insertion";
        }
        catch (IllegalArgumentException ex)
        {
            return "admin/Instructor-form";
        }
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
        model.addAttribute("name", "../admin/AdminName.jsp");
        model.addAttribute("serviceCenter", "../admin/ServiceCenter.jsp");

        model.addAttribute("title", "Instructor Updated");
        model.addAttribute("message", "Instructor with ID: " + instructor.getInstructorId() +
                " has been successfully updated.");
        return "generic/Message";
    }

    @GetMapping("/services/delete/getInstructor")
    public String deleteInstructor(Model model)
    {
        model.addAttribute("url", "/admin/services/delete/deletable/instructor");
        model.addAttribute("methodType", propertyHandler.GET);
        model.addAttribute("inputId", propertyHandler.INP_INSTRUCTOR_ID);
        model.addAttribute("displayWho", propertyHandler.DIS_INSTRUCTOR_ID);
        model.addAttribute("max", 3);
        model.addAttribute("min", 3);
        return "admin/GetInstructor";
    }

    @GetMapping("/services/delete/deletable/instructor")
    public String deletableInstructor(@RequestParam("instructorId") Integer instructorId, Model model)
    {
        model.addAttribute("who", propertyHandler.INSTRUCTOR.toLowerCase());
        model.addAttribute("object", ViewRelatedTester.testInstructor());
        model.addAttribute("id", ViewRelatedTester.testInstructor().getInstructorId());
        model.addAttribute("url", "/admin/services/delete/deleted/instructor");
        model.addAttribute("methodType", propertyHandler.GET);
        return "admin/Deletable";
    }

    @GetMapping("/services/delete/deleted/instructor")
    public String instructorDeleted(@RequestParam("id") Integer instructorId, Model model)
    {
        model.addAttribute("name", "../admin/AdminName.jsp");
        model.addAttribute("serviceCenter", "../admin/ServiceCenter.jsp");

        model.addAttribute("title", "Instructor deleted");
        model.addAttribute("message", "Instructor with ID: " +instructorId
                + " has been successfully deleted.");
        return "generic/Message";
    }

    @GetMapping("/services/get/getCourses")
    public String getCourses(Model model)
    {
        List<Course> courses = ViewRelatedTester.demoCourses();
        model.addAttribute("courses", courses);
        return "admin/GetCourses";
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
    public String processCourse(@Valid @ModelAttribute("course")Course course, Model model)
    {
        try
        {
            course = apiService.insertCourse(course);
            model.addAttribute("course", course);
            return "admin/CourseAdded";
        }
        catch (IllegalArgumentException ex)
        {
            return "admin/Course-form";
        }
    }
}

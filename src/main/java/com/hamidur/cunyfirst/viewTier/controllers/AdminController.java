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
import java.io.FileNotFoundException;
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
    public String displayStudent()
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
        model.addAttribute("submitText", propertyHandler.SUB_GET_STUDENT);

        return "admin/GetStudent";
    }

    @GetMapping("/services/get/getInstructor")
    public String getInstructor(Model model)
    {
        model.addAttribute("url", "/admin/services/update/updateable/instructor");
        model.addAttribute("methodType", propertyHandler.GET);
        model.addAttribute("inputId", propertyHandler.INP_INSTRUCTOR_ID);
        model.addAttribute("displayWho", propertyHandler.DIS_INSTRUCTOR_ID);
        model.addAttribute("max", 3);
        model.addAttribute("min", 3);
        model.addAttribute("submitText", propertyHandler.SUB_GET_INSTRUCTOR);
        return "admin/GetInstructor";
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
        // retrieve student from db assign it to a model
        return "admin/DisplayStudent";
    }

    @GetMapping("/services/insert/student")
    public String insertStudent(Model model)
    {
        model.addAttribute("newStudent", new Student());
        try
        {
            model.addAttribute("genders", propertyHandler.getGenders());
            model.addAttribute("states", propertyHandler.getStates());
            model.addAttribute("countries", propertyHandler.getCountries());
        }
        catch (FileNotFoundException ex)
        {
            // redirect
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return "admin/InsertStudent";
    }

    @PostMapping("/services/insert/processed/student")
    public String processNewStudent(@ModelAttribute("newStudent") Student student, Model model)
    {
        // insert into db then redirect if success else error
        System.out.println(student.getGender());
        student.setStudentId(10000001);
        student.setLogin(new Login("username.edu", "", false));
        model.addAttribute("newStudent", student);
        return "admin/StudentAdded";
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
        model.addAttribute("submitText", propertyHandler.SUB_GET_STUDENT);
        return "admin/GetStudent";
    }

    @GetMapping("/services/update/updateable/student")
    public String updateableStudent(@RequestParam("studentId") Integer studentId, Model model)
    {
        //
        return "admin/UpdateableStudent";
    }

    @GetMapping("/services/delete/getStudent")
    public String deleteStudent() { return "admin/DeleteGetStudent"; }

    @GetMapping("/services/delete/deletable/student")
    public String deletableStudent(@RequestParam("studentId") Integer studentId, Model model)
    {
        //
        return "admin/DeletableStudent";
    }

    @GetMapping("/services/insert/instructor")
    public String insertInstructor(Model model)
    {
        model.addAttribute("newInstructor", new Instructor());
        try
        {
            model.addAttribute("genders", propertyHandler.getGenders());
        }
        catch (IOException ex)
        {
            // redirect
            System.out.println(ex.getMessage());
        }
        return "admin/InsertInstructor";
    }

    @PostMapping("/services/insert/processed/instructor")
    public String processNewInstructor(@ModelAttribute("newInstructor") Instructor instructor, Model model)
    {
        // insert into db then redirect if success else error
        model.addAttribute("newInstructor", instructor);
        return "admin/InstructorAdded";
    }

    @GetMapping("/services/insert/course")
    public String insertCourse(Model model)
    {
        model.addAttribute("newCourse", new Course());
        try
        {
            model.addAttribute("courseNames", propertyHandler.getCourseNames());
            model.addAttribute("courseLevels", propertyHandler.getCourseLevels());
            model.addAttribute("courseCredits", propertyHandler.getCourseCredits());
        }
        catch (IOException ex)
        {
            // redirect
            System.out.println(ex.getMessage());
        }
        return "admin/InsertCourse";
    }

    @PostMapping("/services/insert/processed/course")
    public String processCourse(@ModelAttribute("newCourse")Course course, Model model)
    {
        System.out.println(course);
        course.setCourseId(101);
        model.addAttribute("newCourse", course);
        return "admin/CourseAdded";
    }
}

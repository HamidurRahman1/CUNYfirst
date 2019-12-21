package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.serviceTier.ApiService;
import com.hamidur.cunyfirst.viewTier.ViewRelatedTester;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Instructor;
import com.hamidur.cunyfirst.viewTier.models.InstructorCourse;
import com.hamidur.cunyfirst.viewTier.models.InstructorLogin;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.PropertyHandler;
import com.hamidur.cunyfirst.viewTier.models.StudentCourse;
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
import java.lang.reflect.Array;
import java.util.Arrays;

@Controller
@RequestMapping("/instructor")
public class InstructorController
{
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApiService apiService;
    @Autowired
    private PropertyHandler propertyHandler;

    @RequestMapping("/login")
    public String instructorLogin(Model model)
    {
        model.addAttribute("login", applicationContext.getBean(InstructorLogin.class));
        model.addAttribute("title", "Instructor");
        model.addAttribute("url", "/instructor/processInstructorLogin");
        model.addAttribute("methodType", propertyHandler.POST);
        return "generic/Login";
    }

    @GetMapping("/instructorCenter")
    public String instructorCenter()
    {
        return "instructor/InstructorCenter";
    }

    @PostMapping("/processInstructorLogin")
    public String processLogin(@ModelAttribute("login") InstructorLogin login, HttpSession session)
    {
        Instructor instructor = ViewRelatedTester.testInstructor();
        session.setAttribute("instructor", instructor);
        return "redirect:/instructor/instructorCenter";
    }

    @GetMapping("/get/getCourses")
    public String getCourses(Model model, HttpSession session)
    {
        Instructor instructor = (Instructor) session.getAttribute("instructor");
        model.addAttribute("insCourses", apiService.getInstructorCoursesByInstructorId(instructor.getInstructorId()));
        return "instructor/InstructorCourses";
    }

    @GetMapping("/logout")
    public String logoutInstructor(HttpSession session)
    {
        session.removeAttribute("instructor");
        return "redirect:/instructor/login";
    }

    @GetMapping("/get/getStudentForm")
    public String getStudent()
    {
        return "instructor/GetStudent";
    }

    @GetMapping("/get/getStudentCourse")
    public String getStudent(@RequestParam("studentId")Integer studentId, Model model, HttpSession session)
    {
        try
        {
            Instructor instructor = (Instructor) session.getAttribute("instructor");
            StudentCourse studentCourse = apiService.getStudentCourseByInstructorId(instructor.getInstructorId(), studentId);

            model.addAttribute("studentCourse", studentCourse);
            model.addAttribute("grades", propertyHandler.getGrades());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return "instructor/StudentCourseGrade";
    }

    @PostMapping("/update/grades")
    public String updateGrades(@ModelAttribute StudentCourse studentCourse, Model model)
    {
        try
        {
            apiService.updateStudentGrade(studentCourse);

            model.addAttribute("name", "../instructor/InstructorName.jsp");
            model.addAttribute("serviceCenter", "../instructor/ServiceCenter.jsp");

            model.addAttribute("title", "Student Updated");
            model.addAttribute("message", "Student with ID: "+studentCourse.getStudent().getStudentId()
                    +" has been successfully updated.");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return "generic/Message";
    }
}

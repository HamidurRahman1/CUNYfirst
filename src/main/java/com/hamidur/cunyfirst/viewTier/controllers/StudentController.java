package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.serviceTier.ApiService;
import com.hamidur.cunyfirst.viewTier.ViewRelatedTester;
import com.hamidur.cunyfirst.viewTier.models.FAFSA;
import com.hamidur.cunyfirst.viewTier.models.Login;

import com.hamidur.cunyfirst.viewTier.models.PropertyHandler;
import com.hamidur.cunyfirst.viewTier.models.Student;
import com.hamidur.cunyfirst.viewTier.models.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.util.Set;

@Controller
@RequestMapping("/student")
public class StudentController
{
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ApiService apiService;
    @Autowired
    private PropertyHandler propertyHandler;

    @GetMapping("/login")
    public String studentLogin(Model model)
    {
        model.addAttribute("login", applicationContext.getBean(Login.class));
        model.addAttribute("title", "Student");
        model.addAttribute("url", "/student/processStudentLogin");
        model.addAttribute("methodType", propertyHandler.POST);
        return "generic/Login";
    }

    @GetMapping("/logout")
    public String logoutInstructor(HttpSession session)
    {
        session.removeAttribute("student");
        return "redirect:/student/login";
    }

    @PostMapping("/processStudentLogin")
    public String processLogin(@ModelAttribute("login") Login login, HttpSession session)
    {
        try
        {
            Student student = apiService.getStudentByLogin(login.getUsername(), login.getPassword());
            student.setLogin(login);
            session.setAttribute("student", student);
            return "redirect:/student/studentCenter";
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return "redirect:/error/Errors";
        }
    }

    @GetMapping("/studentCenter")
    public String displayStudent()
    {
        return "student/StudentCenter";
    }

    @GetMapping("/get/getFAFSAs")
    public String getFafsas(Model model, @SessionAttribute("student")Student student)
    {
        Set<FAFSA> fafsas = apiService.getStudentFafsas(student.getStudentId());
        student.setFafsas(fafsas);
        model.addAttribute("fafsas", fafsas);
        return "student/DisplayFafsas";
    }

    @GetMapping("/get/getCourseHistory")
    public String getThisStudentCourseHistory(Model model, @SessionAttribute("student")Student student)
    {
        Set<StudentCourse> set = apiService.getStudentCourseHistory(student.getStudentId());
        student.setStudentCourses(set);
        model.addAttribute("studentCourse", set);
        return "student/CourseHistory";
    }

    @GetMapping("/get/getCourses")
    public String getCourses(Model model)
    {
        model.addAttribute("courses", apiService.getOfferedCourses());
        return "student/GetCourses";
    }
}

package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.viewTier.ViewRelatedTester;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Instructor;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController
{
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

    @GetMapping("/services/insertStudent")
    public String insertStudent(Model model)
    {
        model.addAttribute("newStudent", new Student());
        return "admin/InsertStudent";
    }

    @PostMapping("/services/process")
    public String processNewStudent(@ModelAttribute("newStudent") Student student, Model model)
    {
        // insert into db then redirect if success else error
        System.out.println(student);
        System.out.println(student.getAddress());
        System.out.println(student.getContact());
        System.out.println(student.getHighSchoolInfo());
        student.setStudentId(10000001);
        student.setLogin(new Login("username.edu", "", false));
        model.addAttribute("newStudent", student);
        return "admin/StudentAdded";
    }

    @GetMapping("/services/getStudent")
    public String getStudent()
    {
        return "admin/GetStudent";
    }

    @GetMapping("/services/displayStudent")
    public String displayStudent(@RequestParam("studentId") Integer studentId, Model model)
    {
        // retrieve student from db assign it to a model
        return "admin/DisplayStudent";
    }

    @GetMapping("/services/insertInstructor")
    public String insertInstructor(Model model)
    {
        model.addAttribute("newInstructor", new Instructor());
        return "admin/InsertInstructor";
    }

    @PostMapping("/services/pInstructor")
    public String processNewInstructor(@ModelAttribute("newInstructor") Instructor instructor, Model model)
    {
        // insert into db then redirect if success else error
        model.addAttribute("newInstructor", instructor);
        return "admin/InstructorAdded";
    }
}

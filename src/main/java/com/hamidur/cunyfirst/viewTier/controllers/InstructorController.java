package com.hamidur.cunyfirst.viewTier.controllers;

import com.hamidur.cunyfirst.viewTier.ViewRelatedTester;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Instructor;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.PropertyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/instructor")
public class InstructorController
{
    @Autowired
    private PropertyHandler propertyHandler;

    @RequestMapping("/login")
    public String instructorLogin(Model model)
    {
        model.addAttribute("login", new Login());
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
    public String processLogin(@ModelAttribute("login") Login login, HttpSession session)
    {
        Instructor instructor = ViewRelatedTester.testInstructor();
        session.setAttribute("instructor", instructor);
        return "redirect:/instructor/instructorCenter";
    }
}

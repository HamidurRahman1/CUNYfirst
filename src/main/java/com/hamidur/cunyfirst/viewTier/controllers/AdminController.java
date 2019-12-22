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
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController
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
    public String processLogin(@ModelAttribute("login") Login login, HttpSession session, Model model)
    {
        try
        {
            Admin admin = apiService.getAdminByLogin(login.getUsername(), login.getPassword());
            session.setAttribute("admin", admin);
            return "redirect:/admin/services";
        }
        catch (Exception ex)
        {
            model.addAttribute("error", ex.getMessage());
            return "redirect:/error/Error";
        }
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
            model.addAttribute("error", ex.getMessage());
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

            Student student = applicationContext.getBean(Student.class);

            model.addAttribute("student", student);
            model.addAttribute("genders", propertyHandler.getGenders());
            model.addAttribute("states", propertyHandler.getStates());
            model.addAttribute("countries", propertyHandler.getCountries());
            model.addAttribute("title", "Adding a Student");
            return "admin/Student-form";
        }
        catch (IOException ex) {
            model.addAttribute("error", ex.getMessage());
            return "redirect:/error/Error";
        }
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
        catch(IllegalArgumentException ex)
        {
            model.addAttribute("error", ex.getMessage());
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
            model.addAttribute("student", apiService.getStudentById(studentId));
            model.addAttribute("genders", propertyHandler.getGenders());
            model.addAttribute("states", propertyHandler.getStates());
            model.addAttribute("countries", propertyHandler.getCountries());
            model.addAttribute("title", "Updating a Student");
            model.addAttribute("studentId", studentId);
            return "admin/Student-form";
        }
        catch (IOException ex)
        {
            model.addAttribute("error", ex.getMessage());
            return "redirect:/error/Error";
        }
    }

    @PostMapping("/services/update/updated/student")
    public String updatesStudent(@ModelAttribute("student") Student student,
                                 @ModelAttribute("studentId") String studentId, Model model)
    {
        model.addAttribute("name", "../admin/AdminName.jsp");
        model.addAttribute("serviceCenter", "../admin/ServiceCenter.jsp");

        try
        {
            System.out.println(student.getStudentId() + " - " + studentId);

            student.setStudentId(Integer.parseInt(studentId));

            apiService.updateStudentsInfo(student);

            model.addAttribute("title", "Student Updated");
            model.addAttribute("message", "Student with ID: "+student.getStudentId()
                    +" has been successfully updated.");
            return "generic/Message";
        }
        catch (Exception ex)
        {
            return "redirect:/admin/services/update/updateable/student?studentId="+student.getStudentId();
        }
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
        Student student = apiService.getStudentById(studentId);
        model.addAttribute("who", propertyHandler.STUDENT.toLowerCase());
        model.addAttribute("id", student.getStudentId());
        model.addAttribute("url", "/admin/services/delete/deleted/student");
        model.addAttribute("methodType", propertyHandler.GET);
        model.addAttribute("object", student);
        return "admin/Deletable";
    }

    @GetMapping("/services/delete/deleted/student")
    public String studentDeleted(@ModelAttribute("id") Integer studentId, Model model)
    {
        apiService.deleteStudent(studentId);
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
            model.addAttribute("instructor", applicationContext.getBean(Instructor.class));
            model.addAttribute("url", "/admin/services/insert/processed/instructor");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("genders", propertyHandler.getGenders());
            return "admin/Instructor-form";
        }
        catch (IOException ex)
        {
            model.addAttribute("error", ex.getMessage());
            return "redirect:/error/Error";
        }
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
            model.addAttribute("instructor", apiService.getInstructorById(instructorId));
            model.addAttribute("genders", propertyHandler.getGenders());
            return "admin/Instructor-form";
        }
        catch (IOException ex)
        {
            model.addAttribute("error", ex.getMessage());
            return "redirect:/error/Error";
        }
    }

    @PostMapping("/services/update/updated/instructor")
    public String updatedInstructor(@ModelAttribute("instructor")Instructor instructor, Model model)
    {
        apiService.updateInstructorInfo(instructor);

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
        Instructor instructor = apiService.getInstructorById(instructorId);

        model.addAttribute("who", propertyHandler.INSTRUCTOR.toLowerCase());
        model.addAttribute("object", instructor);
        model.addAttribute("id", instructor.getInstructorId());
        model.addAttribute("url", "/admin/services/delete/deleted/instructor");
        model.addAttribute("methodType", propertyHandler.GET);
        return "admin/Deletable";
    }

    @GetMapping("/services/delete/deleted/instructor")
    public String instructorDeleted(@ModelAttribute("id") Integer instructorId, Model model)
    {
        apiService.deleteInstructor(instructorId);
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
        model.addAttribute("courses", apiService.getOfferedCourses());
        return "admin/GetCourses";
    }

    @GetMapping("/services/insert/course")
    public String insertCourse(Model model)
    {
        try
        {
            model.addAttribute("url", "/admin/services/insert/processed/course");
            model.addAttribute("methodType", propertyHandler.POST);
            model.addAttribute("course", applicationContext.getBean(Course.class));
            model.addAttribute("courseNames", propertyHandler.getCourseNames());
            model.addAttribute("courseLevels", propertyHandler.getCourseLevels());
            model.addAttribute("courseCredits", propertyHandler.getCourseCredits());
            return "admin/Course-form";
        }
        catch (IOException ex)
        {
            model.addAttribute("error", ex.getMessage());
            return "redirect:/error/Error";
        }
    }

    @PostMapping("/services/insert/processed/course")
    public String processCourse(@ModelAttribute("course")Course course, Model model)
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

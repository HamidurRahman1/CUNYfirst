package com.hamidur.cunyfirst.viewTier;

import com.hamidur.cunyfirst.viewTier.models.Address;
import com.hamidur.cunyfirst.viewTier.models.Admin;
import com.hamidur.cunyfirst.viewTier.models.Contact;
import com.hamidur.cunyfirst.viewTier.models.Course;
import com.hamidur.cunyfirst.viewTier.models.CourseName;
import com.hamidur.cunyfirst.viewTier.models.CourseStatus;
import com.hamidur.cunyfirst.viewTier.models.FAFSA;
import com.hamidur.cunyfirst.viewTier.models.Gender;
import com.hamidur.cunyfirst.viewTier.models.Grade;
import com.hamidur.cunyfirst.viewTier.models.HighSchoolInfo;
import com.hamidur.cunyfirst.viewTier.models.Login;
import com.hamidur.cunyfirst.viewTier.models.PropertyFileReader;
import com.hamidur.cunyfirst.viewTier.models.Student;
import com.hamidur.cunyfirst.viewTier.models.StudentCourse;
import com.hamidur.cunyfirst.viewTier.models.Term;
import com.hamidur.cunyfirst.viewTier.models.TransferInfo;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ViewRelatedTester
{
    public static void main(java.lang.String[] args)
    {
        try
        {
            Student student = testStudent();

            System.out.println(student);
            System.out.println(student.getAddress());
            System.out.println(student.getContact());
            System.out.println(student.getHighSchoolInfo());
            System.out.println(student.getTransferInfo());
            System.out.println(student.getLogin());
            System.out.println(student.getStudentCourses());
            System.out.println(student.getFafsas());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Student testStudent()
    {
        Student student = new Student("Hamidur", "Rahman", "ssn", LocalDate.now(), Gender.M.toString());
        student.setStudentId(20021001);
        student.setAddress(testAddress());
        student.setContact(testContact());
        student.setHighSchoolInfo(testHighSchoolInfo());
        student.setTransferInfo(testTransferInfo());
        student.setLogin(testLogin());
        student.setStudentCourses(studentCourses());
        student.setFafsas(fafsas());
        return student;
    }

    public static Set<FAFSA> fafsas()
    {
        Set<FAFSA> fafsas = new LinkedHashSet<>();
        fafsas.add(new FAFSA(testTerm().get(0), 1890.50));
        fafsas.add(new FAFSA(testTerm().get(1), 2100.00));
        return fafsas;
    }

    public static Admin testAdmin()
    {
        return new Admin("Hamidur", "Rahman", "ssn", LocalDate.now(), Gender.F.toString());
    }
    
    public static Address testAddress()
    {
        return new Address("st", "crst", "city", "street", "zipcode");
    }
    
    public static Contact testContact()
    {
        return new Contact("1112220000", "personal@email.com", "college@college.edu");
    }
    
    public static HighSchoolInfo testHighSchoolInfo()
    {
        return new HighSchoolInfo("Model High School", 2014, "Sylhet", "BD");
    }
    
    public static TransferInfo testTransferInfo()
    {
        return new TransferInfo("schoolName", testTerm().get(0));
    }
    
    public static List<Term> testTerm()
    {
        return new LinkedList<>(Arrays.asList(new Term("Spring", 2016), new Term("Fall", 2016)));
    }
    
    public static Login testLogin()
    {
        return new Login("hamidur.rahman@college.edu", "hashfunction", true);
    }

    public static List<Course> demoCourses()
    {
        List<Course> courses = new LinkedList<>();

        Course c1 = new Course("Beginner Arts", CourseName.HUA.toString(), 101, 3.0f, "description");

        Course c2 = new Course("Intermediate Accounting", CourseName.BTA.toString(), 111, 3.0f, "description");

        courses.addAll(Arrays.asList(c1, c2));

        return courses;
    }

    public static Set<StudentCourse> studentCourses()
    {
        Set<StudentCourse> studentCourses = new LinkedHashSet<>();
        studentCourses.add(new StudentCourse(demoCourses().get(0), CourseStatus.TAKEN.getValue(),
                Grade.A_MINUS.getValue(), testTerm().get(0)));
        studentCourses.add(new StudentCourse(demoCourses().get(1), CourseStatus.TAKEN.getValue(),
                Grade.A.getValue(), testTerm().get(1)));
        return studentCourses;
    }
}

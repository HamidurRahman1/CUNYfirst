package com.hamidur.cunyfirst.viewTier.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class Student extends Person implements Serializable
{
    private Integer studentId;
    private Address address;
    private Contact contact;
    private HighSchoolInfo highSchoolInfo;
    private TransferInfo transferInfo;
    private Login login;
    @Autowired
    private Map<SecurityQuestion, String> questionAnswers;
    @Autowired
    private Set<FAFSA> fafsas;
    @Autowired
    private Set<StudentCourse> studentCourses;
    
    public Student()
    {
        super();
    }
    
    public Student(String firstName, String lastName, String ssn, String dateOfBirth, String gender)
    {
        super(firstName, lastName, ssn, dateOfBirth, gender);
    }
    
    public Integer getStudentId()
    {
        return studentId;
    }
    
    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }
    
    public Address getAddress()
    {
        return address;
    }
    
    public void setAddress(Address address)
    {
        this.address = address;
    }
    
    public Contact getContact()
    {
        return contact;
    }
    
    public void setContact(Contact contact)
    {
        this.contact = contact;
    }
    
    public HighSchoolInfo getHighSchoolInfo()
    {
        return highSchoolInfo;
    }
    
    public void setHighSchoolInfo(HighSchoolInfo highSchoolInfo)
    {
        this.highSchoolInfo = highSchoolInfo;
    }
    
    public TransferInfo getTransferInfo()
    {
        return transferInfo;
    }
    
    public void setTransferInfo(TransferInfo transferInfo)
    {
        this.transferInfo = transferInfo;
    }
    
    public Map <SecurityQuestion, String> getQuestionsAns()
    {
        return questionAnswers;
    }
    
    public void setQuestionAnswers(Map <SecurityQuestion, String> questionsAns)
    {
        this.questionAnswers = questionsAns;
    }
    
    public Login getLogin()
    {
        return login;
    }
    
    public void setLogin(Login login)
    {
        this.login = login;
    }
    
    public Set<FAFSA> getFafsas()
    {
        return fafsas;
    }
    
    public void setFafsas(Set <FAFSA> fafsas)
    {
        this.fafsas = fafsas;
    }
    
    public void addFafsa(FAFSA fafsa)
    {
        fafsas.add(fafsa);
    }
    
    public void removeFafsa(FAFSA fafsa)
    {
        fafsas.remove(fafsa);
    }
    
    public Set <StudentCourse> getStudentCourses()
    {
        return studentCourses;
    }
    
    public void setStudentCourses(Set <StudentCourse> studentCourses)
    {
        this.studentCourses = studentCourses;
    }
    
    public void addStudentCourse(StudentCourse studentCourse)
    {
        studentCourses.add(studentCourse);
    }
    
    public void removeStudentCourse(StudentCourse studentCourse)
    {
        studentCourses.remove(studentCourse);
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}

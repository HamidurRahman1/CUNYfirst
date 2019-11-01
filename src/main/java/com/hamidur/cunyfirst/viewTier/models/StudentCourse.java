package com.hamidur.cunyfirst.viewTier.models;

import java.util.Objects;

public class StudentCourse
{
    private Student student;
    private Course course;
    private String courseStatus;
    private String grade;
    private Term term;
    
    public StudentCourse() {}

    public StudentCourse(Course course, String courseStatus, String grade, Term term)
    {
        this.course = course;
        this.courseStatus = courseStatus;
        this.grade = grade;
        this.term = term;
    }
    
    public StudentCourse(Student student, Course course, String courseStatus, String grade, Term term)
    {
        this.student = student;
        this.course = course;
        this.courseStatus = courseStatus;
        this.grade = grade;
        this.term = term;
    }
    
    public Student getStudent()
    {
        return student;
    }
    
    public void setStudent(Student student)
    {
        this.student = student;
    }
    
    public Course getCourse()
    {
        return course;
    }
    
    public void setCourse(Course course)
    {
        this.course = course;
    }
    
    public String getCourseStatus()
    {
        return courseStatus;
    }
    
    public void setCourseStatus(String courseStatus)
    {
        this.courseStatus = courseStatus;
    }
    
    public String getGrade()
    {
        return grade;
    }
    
    public void setGrade(String grade)
    {
        this.grade = grade;
    }
    
    public Term getTerm()
    {
        return term;
    }
    
    public void setTerm(Term term)
    {
        this.term = term;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof StudentCourse)) return false;
        StudentCourse that = (StudentCourse) o;
        return Objects.equals(getStudent(), that.getStudent())
                && Objects.equals(getCourse(), that.getCourse())
                && getCourseStatus().equals(that.getCourseStatus())
                && Objects.equals(getGrade(), that.getGrade())
                && Objects.equals(getTerm(), that.getTerm());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getStudent(), getCourse(), getCourseStatus(), getGrade(), getTerm());
    }
    
    @Override
    public String toString()
    {
        return "StudentCourse{" + "student=" + student + ", course=" + course + ", courseStatus=" +
                courseStatus + ", grade=" + grade + ", term=" + term + '}';
    }
}

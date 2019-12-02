package com.hamidur.cunyfirst.viewTier.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class StudentCourse
{
    @Autowired
    private Course course;
    @Autowired
    private String courseStatus;
    @Autowired
    private String grade;
    @Autowired
    private Term term;
    
    public StudentCourse() {}

    public StudentCourse(Course course, String courseStatus, String grade, Term term)
    {
        this.course = course;
        this.courseStatus = courseStatus;
        this.grade = grade;
        this.term = term;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentCourse)) return false;
        StudentCourse that = (StudentCourse) o;
        return Objects.equals(getCourse(), that.getCourse()) &&
                Objects.equals(getCourseStatus(), that.getCourseStatus()) &&
                Objects.equals(getGrade(), that.getGrade()) &&
                Objects.equals(getTerm(), that.getTerm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourse(), getCourseStatus(), getGrade(), getTerm());
    }

    @Override
    public String toString()
    {
        return "StudentCourse{" + "course=" + course.getCourseLevel() + ", courseStatus=" +
                courseStatus + ", grade=" + grade + ", term=" + term.getTermName() + '}';
    }
}

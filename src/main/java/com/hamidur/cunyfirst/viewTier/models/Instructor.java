package com.hamidur.cunyfirst.viewTier.models;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class Instructor extends Person implements Serializable
{
    private Integer instructorId;
    @Autowired
    private Set<InstructorCourse> instructorCourses;
    @Autowired
    private InstructorLogin instructorLogin;
    
    public Instructor()
    {
        super();
    }
    
    public Instructor(String firstName, String lastName, String ssn, String dateOfBirth, String gender)
    {
        super(firstName, lastName, ssn, dateOfBirth, gender);
    }

    public Instructor(Integer instructorId, String firstName, String lastName, String ssn, String dateOfBirth, String gender)
    {
        super(firstName, lastName, ssn, dateOfBirth, gender);
        setInstructorId(instructorId);
    }
    
    public Integer getInstructorId()
    {
        return instructorId;
    }
    
    public void setInstructorId(Integer instructorId)
    {
        this.instructorId = instructorId;
    }
    
    public Set <InstructorCourse> getInstructorCourses()
    {
        return instructorCourses;
    }
    
    public void setInstructorCourses(Set <InstructorCourse> instructorCourses)
    {
        this.instructorCourses = instructorCourses;
    }
    
    public void addInstructorCourse(InstructorCourse instructorCourse)
    {
        instructorCourses.add(instructorCourse);
    }
    
    public void removeInstructorCourse(InstructorCourse instructorCourse)
    {
        instructorCourses.remove(instructorCourse);
    }

    public InstructorLogin getLogin() {
        return instructorLogin;
    }

    public void setLogin(InstructorLogin login) {
        this.instructorLogin = login;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Instructor)) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(getInstructorId(), that.getInstructorId())
                && Objects.equals(getInstructorCourses(), that.getInstructorCourses());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getInstructorId(), getInstructorCourses());
    }
    
    @Override
    public String toString()
    {
        return super.toString()+"Instructor{" + "instructorId=" + instructorId + ", instructorCourses=" + instructorCourses + '}';
    }
}

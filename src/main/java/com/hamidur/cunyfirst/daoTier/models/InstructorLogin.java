package com.hamidur.cunyfirst.daoTier.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity(name = "InstructorLogin")
@Table(name = "InstructorLogins")
public class InstructorLogin
{
    @Id
    @Column(name = "username", updatable = false, nullable = false, unique = true)
    private String userName;

    @Column(name = "password", length = 10)
    private String password;

    @Column(name = "isActive", columnDefinition = "TINYINT(1)")
    private Boolean isActive;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "instructorId")
    private Instructor instructor;

    public InstructorLogin() {}

    public InstructorLogin(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public InstructorLogin(String userName, String password, Boolean isActive)
    {
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;
    }

    public InstructorLogin(String userName, String password, Instructor instructor)
    {
        this.userName = userName;
        this.password = password;
        this.instructor = instructor;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InstructorLogin)) return false;
        InstructorLogin that = (InstructorLogin) o;
        return Objects.equals(getUserName(), that.getUserName()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword(), isActive);
    }

    @Override
    public String toString() {
        return "InstructorLogin{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

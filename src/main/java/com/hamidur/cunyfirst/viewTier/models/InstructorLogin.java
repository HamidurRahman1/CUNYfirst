package com.hamidur.cunyfirst.viewTier.models;

import java.util.Objects;

public class InstructorLogin
{
    private String username;
    private String password;
    private Boolean isActive;

    public InstructorLogin() {
    }

    public InstructorLogin(String username, String password, Boolean isActive) {
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(isActive, that.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword(), isActive);
    }

    @Override
    public String toString() {
        return "InstructorLogin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}

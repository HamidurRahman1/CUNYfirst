package com.hamidur.cunyfirst.viewTier.models;

import java.io.Serializable;
import java.util.Objects;

public class Admin extends Person implements Serializable
{
    private Integer adminId;
    
    public Admin()
    {
        super();
    }
    
    public Admin(java.lang.String firstName, java.lang.String lastName, java.lang.String ssn, String dateOfBirth, String string)
    {
        super(firstName, lastName, ssn, dateOfBirth, string);
    }
    
    public Integer getAdminId()
    {
        return adminId;
    }
    
    public void setAdminId(Integer adminId)
    {
        this.adminId = adminId;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(! (o instanceof Admin)) return false;
        Admin admin = (Admin) o;
        return Objects.equals(getAdminId(), admin.getAdminId()) && Objects.equals(super.hashCode(), admin.hashCode());
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(getAdminId(), super.hashCode());
    }
    
    @Override
    public java.lang.String toString()
    {
        return "Admin{" + "adminId=" + adminId + " " + super.toString() +'}';
    }
}

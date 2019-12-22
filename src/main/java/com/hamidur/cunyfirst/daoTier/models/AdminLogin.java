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

@Entity(name = "AdminLogin")
@Table(name = "AdminLogins")
public class AdminLogin
{
    @Id
    @Column(name = "username", updatable = false, nullable = false, unique = true)
    private String userName;

    @Column(name = "password", length = 10)
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "adminId")
    private Admin admin;

    public AdminLogin() {}

    public AdminLogin(String userName, String password)
    {
        this.userName = userName;
        this.password = password;
    }

    public AdminLogin(String userName, String password, Admin admin)
    {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminLogin)) return false;
        AdminLogin that = (AdminLogin) o;
        return Objects.equals(getUserName(), that.getUserName()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getAdmin(), that.getAdmin());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword(), getAdmin());
    }
}

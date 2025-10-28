package com.example.demo.backend.Entities;

public class User {
    private String username;
    private String password;
    private Role role;

    public enum Role {
        HR, Employees
    }

    public String getUserName() {
        return username;
    }

    public String getPassWord() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package com.treeaxes.Model;

import java.util.Date;

public class User {

    private String username,email,pwd;
    private int role;

    public User() {
    }

    public User(String username, String email, String pwd, int role) {
        this.username = username;
        this.email = email;
        this.pwd = pwd;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", role=" + role +
                '}';
    }
}

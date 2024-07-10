package com.c2w.model;

public class UserDetail {
    public UserDetail userDetail; // This field seems like it might be intended to reference another UserDetail object, but it's not used in a typical manner.
    private String userName; // Username of the user
    private String password; // Password of the user
    private String role; // Role or type of user (e.g.,admin, regular user)
    // Getters and setters for each field
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
    public String getRole() {
    return role;
    }
    public void setRole(String role) {
    this.role = role;
    }
    // Override toString() to provide a string representation of the object
    @Override
    public String toString() {
    return "UserDetail [userDetail=" + userDetail + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
    
    }
    }
   
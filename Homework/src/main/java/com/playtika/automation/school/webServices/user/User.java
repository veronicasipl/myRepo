package com.playtika.automation.school.webServices.user;

public class User {

    private String email;
    private int id;
    private String registeredAt;
    private String password;
    private String token;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
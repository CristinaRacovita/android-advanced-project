package com.example.tasty.domain.model;

public class User {
    private String username;
    private String password;

    public User(String EmailAddress, String Password) {
        username = EmailAddress;
        password = Password;
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

    public boolean isEmailValid() {
        return getUsername().length() > 5;
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 5;
    }
}

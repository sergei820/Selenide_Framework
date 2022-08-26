package org.example.models;

import lombok.Getter;

@Getter
public class User {

    private String userLogin;
    private String userPassword;

    public User(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }
}

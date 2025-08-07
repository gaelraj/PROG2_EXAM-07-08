package com.user;

import com.features.Posts;

import java.time.LocalDate;

public class User {
    private UserType userType;
    private String id;
    private String userName;
    private String email;
    private LocalDate creationDate;

    public User(String id, String userName, String email) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.creationDate = LocalDate.now();
    }

    //Getter


    public UserType getUserType() {
        return userType;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    //Setter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String ToString() {
        return userType + " " + id + " " + userName + " " + email + " " + creationDate;
    }
}

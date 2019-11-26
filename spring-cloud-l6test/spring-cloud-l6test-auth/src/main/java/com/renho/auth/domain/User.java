package com.renho.auth.domain;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class User {

    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

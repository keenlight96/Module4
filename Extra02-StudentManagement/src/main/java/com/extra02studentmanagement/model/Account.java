package com.extra02studentmanagement.model;

import java.time.LocalDate;

public class Account {
    private int id;
    private String username;
    private String password;
    private String avatar;
    private LocalDate birthday;

    public Account() {
    }

    public Account(int id, String username, String password, String avatar, String birthday) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.birthday = LocalDate.parse(birthday);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = LocalDate.parse(birthday);
    }
}

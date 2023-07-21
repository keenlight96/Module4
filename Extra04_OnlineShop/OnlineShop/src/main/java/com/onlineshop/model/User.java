package com.onlineshop.model;

import com.onlineshop.validate.group.LoginInfo;
import com.onlineshop.validate.group.UserInfo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull (message = "This field can not be blank",groups = LoginInfo.class)
    @Size(min = 4, message = "At least 4 characters", groups = LoginInfo.class)
    private String username;
    @NotNull (message = "This field can not be blank",groups = LoginInfo.class)
    @Size(min = 3, message = "At least 3 characters", groups = LoginInfo.class)
    private String password;
    @Email (message = "Wrong email format",groups = UserInfo.class)
    private String email;
    @ManyToOne
    private Role role;

    public User() {
    }

    public User(int id, String username, String password, String email, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

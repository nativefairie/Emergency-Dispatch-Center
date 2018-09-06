package com.sdm.emergency_dispatcher_center.domain;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "password")
    @Length(min = 6, message = "Your password must have at least 6 characters")
    @javax.validation.constraints.NotEmpty(message = "Please provide a password")
    // @Transient
    private String password;

    @Column(name = "email")
    @javax.validation.constraints.NotEmpty(message = "Please provide your email")
    private String email;

    @Column(name="userName")
    private String userName;

    @Column(name = "active")
    private boolean active;

    public User(User user) {
        this.active = user.isActive();
        this.email = user.getEmail();
        this.id = user.getId();
        this.password = user.getPassword();
    }

    public User() {

    }
    public User(String userName, String password, String email, long id) {
        this.userName = userName;
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
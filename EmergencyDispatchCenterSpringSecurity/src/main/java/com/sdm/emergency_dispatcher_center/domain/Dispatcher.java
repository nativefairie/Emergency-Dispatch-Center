package com.sdm.emergency_dispatcher_center.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dispatcher")
public class Dispatcher extends User {
    String email;
    String password;
    String userName;
    long id;

    public Dispatcher(String userName, String password, String email, long id) {
            this.email = email;
            this.password = password;
            this.id = id;
            this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

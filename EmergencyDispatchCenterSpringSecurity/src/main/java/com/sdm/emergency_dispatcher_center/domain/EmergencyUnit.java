package com.sdm.emergency_dispatcher_center.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "emergencyUnit")
public class EmergencyUnit extends User {
    OperationType unitType;
    String email;
    String password;
    String userName;
    long id;

    public EmergencyUnit(OperationType unitType, String email, String password, String userName, long id) {
        this.unitType = unitType;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.id = id;
    }

    public EmergencyUnit(long id, String text, Date lastModification, EmergencyUnit lastUnit) {
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

    public OperationType getUnitType() {
        return unitType;
    }

    public void setUnitType(OperationType unitType) {
        this.unitType = unitType;
    }
}

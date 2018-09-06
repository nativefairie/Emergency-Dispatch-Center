package com.sdm.emergency_dispatcher_center.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    Date callingTime;

    Date callingEndTime;

    @OneToOne
    Operation operation;

    public Log(Date callingTime, Date callingEndTime, Operation operation, long id) {
            this.id = id;
            this.callingTime = callingTime;
            this.callingEndTime = callingEndTime;
            this.operation = operation;

    }

    public Log() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCallingTime() {
        return callingTime;
    }

    public void setCallingTime(Date callingTime) {
        this.callingTime = callingTime;
    }

    public Date getCallingEndTime() {
        return callingEndTime;
    }

    public void setCallingEndTime(Date callingEndTime) {
        this.callingEndTime = callingEndTime;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}

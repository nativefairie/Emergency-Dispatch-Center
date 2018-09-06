package com.sdm.emergency_dispatcher_center.domain;

import com.sdm.emergency_dispatcher_center.repository.LogRepository;
import com.sdm.emergency_dispatcher_center.repository.ReportRepository;
import com.sdm.emergency_dispatcher_center.repository.UserRepository;
import com.sdm.emergency_dispatcher_center.service.OperationDto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    OperationType type;
    OperationPriority priority;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Address address;
    String who;
    String what;
    String additionalInfo;

    @ManyToOne
    Dispatcher initializer;

    @ManyToOne
    EmergencyUnit assignedUnit;

    @OneToOne(cascade = CascadeType.PERSIST)
    Report report;

    @OneToOne
    Log log;

    Date startTime;

    Date endTime;

    public Operation(OperationType type, OperationPriority priority, Address address, String who, String what, String additionalInfo, Dispatcher initializer, EmergencyUnit assignedUnit, Report report, Log log, Date startTime, Date endTime, long id) {
            this.id = id;
            this.type = type;
            this.priority = priority;
            this.address = address;
            this.who = who;
            this.what = what;
            this.additionalInfo = additionalInfo;
            this.initializer = initializer;
            this.assignedUnit = assignedUnit;
            this.report = report;
            this.log = log;
            this.startTime = startTime;
            this.endTime = endTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public OperationPriority getPriority() {
        return priority;
    }

    public void setPriority(OperationPriority priority) {
        this.priority = priority;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Dispatcher getInitializer() {
        return initializer;
    }

    public void setInitializer(Dispatcher initializer) {
        this.initializer = initializer;
    }

    public EmergencyUnit getAssignedUnit() {
        return assignedUnit;
    }

    public void setAssignedUnit(EmergencyUnit assignedUnit) {
        this.assignedUnit = assignedUnit;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setAssignedUnit(String remoteUser) {
    }
}

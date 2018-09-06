package com.sdm.emergency_dispatcher_center.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String text;

    Date lastModification;

    @ManyToOne
    EmergencyUnit lastUnit;

    public Report(String text, Date lastModification, EmergencyUnit lastUnit, Long id) {
        this.text = text;
        this.lastModification = lastModification;
        this.lastUnit = lastUnit;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

    public EmergencyUnit getLastUnit() {
        return lastUnit;
    }

    public void setLastUnit(EmergencyUnit lastUnit) {
        this.lastUnit = lastUnit;
    }


}

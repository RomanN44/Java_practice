package com.example.practice.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Resource  implements Serializable {
    private static final long serialVersionUID = 1L;
    private long resource_id;
    private long doctor_id;
    private long user_id;
    private boolean isOpen;
    private Date date; //TODO change type of variable, if it will need
    private Time time;

    public long getResource_id() {
        return resource_id;
    }

    public void setResource_id(long resource_id) {
        this.resource_id = resource_id;
    }

    public long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}

package com.example.practice.model;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;

public class History implements Serializable {
    private long id;
    private long user_id;
    private long resource_id;
    private String operation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getResource_id() {
        return resource_id;
    }

    public void setResource_id(long resource_id) {
        this.resource_id = resource_id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}

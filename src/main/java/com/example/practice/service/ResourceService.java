package com.example.practice.service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface ResourceService {
    List loadAllFreeResources();
    void bookingResource(long resource_id, long user_id);
    List loadUsersResources(long user_id);
    void clearResource(long resource_id);
    List findResource(String first_name, String second_name, String specialty);
}

package com.example.practice.dao;

import java.util.List;

public interface ResourceDao {
    List loadAllResources();
    void bookingResource(long resource_id, long user_id);
    List loadUsersResources(long user_id);
    void clearResource(long resource_id);
}

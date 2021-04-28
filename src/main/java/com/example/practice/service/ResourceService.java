package com.example.practice.service;

import java.util.List;

public interface ResourceService {
    List loadAllFreeResources();
    void bookingResource(long resource_id, long user_id);
    List loadUsersResources(long user_id);
    void clearResource(long resource_id);
}

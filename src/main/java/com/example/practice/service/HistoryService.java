package com.example.practice.service;

public interface HistoryService {
    void createRecord(long user_id, long resource_id, String operation);
}

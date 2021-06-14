package com.example.practice.dao;

public interface HistoryDao {
    void insert(long user_id, long resource_id, String operation);
}

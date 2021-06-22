package com.example.practice.service;

import com.example.practice.dao.HistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private HistoryDao historyDao;

    public void createRecord(long user_id, long resource_id, String operation) {
        historyDao.insert(user_id, resource_id, operation);
    }
}

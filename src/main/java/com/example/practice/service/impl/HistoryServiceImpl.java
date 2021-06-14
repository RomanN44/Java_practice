package com.example.practice.service.impl;

import com.example.practice.dao.HistoryDao;
import com.example.practice.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;
    @Override
    public void createRecord(long user_id, long resource_id, String operation) {
        historyDao.insert(user_id, resource_id, operation);
    }
}

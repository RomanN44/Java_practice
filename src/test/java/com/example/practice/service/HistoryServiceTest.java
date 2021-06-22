package com.example.practice.service;

import com.example.practice.dao.HistoryDao;
import com.example.practice.service.HistoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceTest {

    @Mock
    private HistoryDao historyDao;

    @InjectMocks
    private HistoryService historyService;

    @Test
    public void createRecord() {
        //testing
        historyService.createRecord(1, 1, "some_operation");
        //validate
        verify(historyDao).insert(1, 1, "some_operation");
    }
}
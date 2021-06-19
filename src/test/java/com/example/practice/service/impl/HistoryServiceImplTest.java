package com.example.practice.service.impl;

import com.example.practice.dao.DoctorDao;
import com.example.practice.dao.HistoryDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HistoryServiceImplTest {

    @Mock
    private HistoryDao historyDao;

    @InjectMocks
    private HistoryServiceImpl  historyService;

    @Test
    public void createRecord() {
        //testing
        historyService.createRecord(1, 1, "some_operation");
        //validate
        verify(historyDao).insert(1, 1, "some_operation");
    }
}
package com.example.practice.service;

import com.example.practice.dao.DoctorDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DoctorServiceTest {

    @Mock
    private DoctorDao doctorDao;

    @InjectMocks
    private DoctorService doctorService;

    @Test
    public void loadAllDoctors() {
        //testing
        List list = doctorService.loadAllDoctors();
        //validate
        verify(doctorDao).loadAllDoctors();
    }
}
package com.example.practice.service.impl;

import com.example.practice.dao.DoctorDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DoctorServiceImplTest {

    @Mock
    private DoctorDao doctorDao;

    @InjectMocks
    private DoctorServiceImpl doctorService;

//    @Before
//    public void setUp() throws Exception {
//        doctorService = new DoctorServiceImpl();
//    }

    @Test
    public void loadAllDoctors() {
        //prepare
        //when(doctorDao.loadAllDoctors()).thenReturn(ImmutableList.of());
        //testing
        List list = doctorService.loadAllDoctors();
        //validate
        verify(doctorDao).loadAllDoctors();
    }
}
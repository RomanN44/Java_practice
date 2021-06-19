package com.example.practice.service.impl;

import com.example.practice.dao.DoctorDao;
import com.example.practice.dao.ResourceDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ResourceServiceImplTest {

    @Mock
    private ResourceDao resourceDao;

    @Mock
    private DoctorDao doctorDao;

    @InjectMocks
    private ResourceServiceImpl resourceService;

    @Test
    public void loadAllFreeResources() {
        //testing
        List list = resourceService.loadAllFreeResources();
        //validate
        verify(resourceDao).loadAllResources();
    }

    @Test
    public void bookingResource() {
        //testing
        resourceService.bookingResource(1, 1);
        //validate
        verify(resourceDao).bookingResource(1, 1);
    }

    @Test
    public void loadUsersResources() {
        //testing
        List list = resourceService.loadUsersResources(1);
        //validate
        verify(resourceDao).loadUsersResources(1);
    }

    @Test
    public void clearResource() {
        //testing
        resourceService.clearResource( 1);
        //validate
        verify(resourceDao).clearResource( 1);
    }

    @Test
    public void findResource() {
        //testing
        List list = resourceService.findResource("Иванов", "Иван", "Терапевт");
        //validate
        verify(resourceDao).findResource("Иванов", "Иван", "Терапевт");
    }
}
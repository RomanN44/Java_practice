package com.example.practice.service;

import com.example.practice.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.User;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailServiceTest {

    @Mock
    private UserDaoImpl userDao;

    @InjectMocks
    private UserDetailService userDetailService;

    @Test
    public void loadUserByUsername() {
        //testing
        User user = (User) userDetailService.loadUserByUsername("root");
        //validate
        verify(userDao).findByLogin("root");
    }
}
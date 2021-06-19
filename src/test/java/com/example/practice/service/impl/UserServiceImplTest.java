package com.example.practice.service.impl;

import com.example.practice.dao.impl.UserDaoImpl;
import com.example.practice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
    @Mock
    private UserDaoImpl userDao;

    @Mock
    private UserDetailServiceImpl userDetailService;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void findByLogin() {
        //testing
        User user = userService.findByLogin("root");
        //validate
        verify(userDetailService).loadUserByUsername("root");
    }

    @Test
    public void isExist() {
        //testing
        Boolean is_exist = userService.isExist("root");
        //validate
        verify(userDao).getIdByLogin("root");
    }

    @Test
    public void getIdByLogin() {
        //testing
        Long id = userService.getIdByLogin("root");
        //validate
        verify(userDao).getIdByLogin("root");
    }

}

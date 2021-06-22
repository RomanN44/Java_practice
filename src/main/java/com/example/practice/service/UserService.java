package com.example.practice.service;

import com.example.practice.dao.impl.UserDaoImpl;
import com.example.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private UserDetailService userDetailService;

    public User findByLogin(String login) {
        return (User) userDetailService.loadUserByUsername(login);
    }

    public boolean isExist(String login)
    {
        return userDao.getIdByLogin(login) != null;
    }

    public long getIdByLogin(String login) {
        return Long.parseLong(userDao.getIdByLogin(login));
    }
}

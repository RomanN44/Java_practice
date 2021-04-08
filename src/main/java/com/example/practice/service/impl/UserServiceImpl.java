package com.example.practice.service.impl;

import com.example.practice.dao.impl.UserDaoImpl;
import com.example.practice.model.User;
import com.example.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    public void insert(User user) {

    }

    @Override
    public void save(User user) {

    }

    @Override
    public User findByLogin(String login) {
        return (User) userDetailService.loadUserByUsername(login);
    }

    @Override
    public boolean isExist(String login)
    {
        return userDao.getIdByLogin(login) != null;
    }

    @Override
    public long getIdByLogin(String login) {
        return Long.parseLong(userDao.getIdByLogin(login));
    }
}

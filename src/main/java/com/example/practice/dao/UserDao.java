package com.example.practice.dao;

import com.example.practice.model.User;

public interface UserDao {
    void insert(User user);
    User findByLogin(String login);
    String getIdByLogin(String login);
}

package com.example.practice.dao;

import com.example.practice.model.User;

import java.util.List;

public interface UserDao {
    void insert(User user);
    User findByLogin(String login);
    String getIdByLogin(String login);
}

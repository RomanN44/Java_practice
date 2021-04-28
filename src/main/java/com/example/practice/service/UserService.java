package com.example.practice.service;

import com.example.practice.model.User;

public interface UserService {
    User findByLogin(String login);
    long getIdByLogin(String login);
    boolean isExist(String login);
}

package com.example.practice.mapper;

import com.example.practice.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setUser_id(resultSet.getLong("user_id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setFirst_name(resultSet.getString("first_name"));
        user.setSecond_name(resultSet.getString("second_name"));
        user.setBirthday(resultSet.getDate("birthday"));
        user.setSex(resultSet.getBoolean("sex"));
        user.setRole(resultSet.getString("role"));
        return user;
    }
}

package com.example.practice.dao.impl;

import com.example.practice.dao.UserDao;
import com.example.practice.mapper.UserMapper;
import com.example.practice.model.Doctor;
import com.example.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public User findByLogin(String login) {
        String sql = "select * from users where login = ?";
        return (User) getJdbcTemplate().queryForObject(sql, new UserMapper(), login);
    }

    @Override
    public String getIdByLogin(String login){
        String sql = "select user_id from users where login = ?";
        try {
            return getJdbcTemplate().queryForObject(sql, String.class, login);
        }
        catch (Exception e)
        {
            return null;
        }
    }
}

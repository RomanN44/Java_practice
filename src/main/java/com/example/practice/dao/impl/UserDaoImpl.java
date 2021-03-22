package com.example.practice.dao.impl;

import com.example.practice.dao.UserDao;
import com.example.practice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String sql = "INSERT INTO users" +
                "(login, password, first_name, second_name, birthday, sex)" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        getJdbcTemplate().update(sql, new Object[]{
                user.getLogin(), user.getPassword(), user.getFirst_name(), user.getSecond_name(), user.getBirthday(), user.isSex()
        });
    }

    @Override
    public User findByLogin(String login) {
        String sql = "select * from users where login = ?";

        return (User)getJdbcTemplate().queryForObject(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
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
        }, login);
    }
}

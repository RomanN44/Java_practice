package com.example.practice.dao.impl;

import com.example.practice.dao.HistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class HistoryDaoImpl extends JdbcDaoSupport implements HistoryDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public void insert(long user_id, long resource_id, String operation) {
        String sql = "INSERT INTO history " +
                "(user_id, resource_id, operation) VALUES (?, ?, ?)" ;
        getJdbcTemplate().update(sql, new Object[]{
                user_id, resource_id, operation
        });
    }
}

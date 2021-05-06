package com.example.practice.dao.impl;

import com.example.practice.dao.ResourceDao;
import com.example.practice.model.Resource;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.swing.text.html.parser.Parser;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ResourceDaoImpl extends JdbcDaoSupport implements ResourceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public List loadAllResources() {
        String sql = "SELECT * FROM resource";
        List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);
        return getList(rows);
    }

    @Override
    public void bookingResource(long resource_id, long user_id) {
        String sql = "UPDATE resource SET user_id=?, is_open=false WHERE resource_id=?";
        jdbcTemplate.update(sql, user_id, resource_id);
    }

    @Override
    public List loadUsersResources(long user_id) {
        String sql = "SELECT * FROM resource WHERE user_id=?";
        List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql, user_id);
        return getList(rows);
    }

    @NotNull
    private List getList(List<Map<String, Object>> rows) {
        List<Resource> result = new ArrayList<>();
        for (Map<String, Object> row:rows){
            Resource res = new Resource();
            res.setResource_id((Long)row.get("resource_id"));
            res.setDoctor_id((Long)row.get("doctor_id"));
            res.setUser_id(0L);
            res.setOpen((Boolean)row.get("is_open"));
            res.setDate((Date)row.get("date"));
            res.setTime((Time)row.get("time"));
            result.add(res);
        }
        return result;
    }

    @Override
    public void clearResource(long resource_id) {
        String sql = "UPDATE resource SET user_id=null, is_open=true WHERE resource_id=?";
        jdbcTemplate.update(sql, resource_id);
    }

    @Override
    public List findResource(String first_name, String second_name, String specialty) {
        String sql = "SELECT * FROM resource WHERE doctor_id in " +
                "(SELECT doctor_id FROM doctors where " +
                " lower(first_name) like lower(?) " +
                " and lower(second_name) like lower(?)" +
                " and lower(specialty) like lower(?))";

        List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql, first_name, second_name, specialty);
        return getList(rows);
    }
}

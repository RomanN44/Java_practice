package com.example.practice.dao.impl;

import com.example.practice.dao.DoctorDao;
import com.example.practice.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class DoctorDaoImpl extends JdbcDaoSupport implements DoctorDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public List loadAllDoctors() {
        String sql = "SELECT * FROM doctors";
        List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Doctor> result = new ArrayList<>();
        for (Map<String, Object> row:rows){
            Doctor doc = new Doctor();
            doc.setDoctor_id((Long)row.get("doctor_id"));
            doc.setFirst_name((String)row.get("first_name"));
            doc.setSecond_name((String)row.get("second_name"));
            doc.setPatronymic((String)row.get("patronymic"));
            doc.setSpecialty((String)row.get("specialty"));
            doc.setSex((boolean)row.get("sex"));
            result.add(doc);
        }
        return result;
    }
}

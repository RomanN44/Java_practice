package com.example.practice.dao.impl;

import com.example.practice.dao.DoctorDao;
import com.example.practice.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public String findFullNameById(long id) {
        String first_name = getJdbcTemplate().queryForObject("SELECT first_name FROM doctors WHERE doctor_id = ?", String.class, id);
        String second_name = getJdbcTemplate().queryForObject("SELECT second_name FROM doctors WHERE doctor_id = ?", String.class, id);
        String patronymic = getJdbcTemplate().queryForObject("SELECT patronymic FROM doctors WHERE doctor_id = ?", String.class, id);
        return first_name + " " + second_name + " " + patronymic;
    }

    @Override
    public String findSpecialtyById(long id) {
        return getJdbcTemplate().queryForObject("SELECT specialty FROM doctors WHERE doctor_id = ?", String.class, id);
    }
}

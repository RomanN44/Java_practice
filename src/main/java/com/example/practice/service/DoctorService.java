package com.example.practice.service;

import com.example.practice.dao.DoctorDao;
import com.example.practice.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    public List<Doctor> loadAllDoctors() {
        return doctorDao.loadAllDoctors();
    }
}

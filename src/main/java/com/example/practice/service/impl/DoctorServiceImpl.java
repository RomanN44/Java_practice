package com.example.practice.service.impl;

import com.example.practice.dao.DoctorDao;
import com.example.practice.model.Doctor;
import com.example.practice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public List<Doctor> loadAllDoctors() {
        return doctorDao.loadAllDoctors();
    }
}

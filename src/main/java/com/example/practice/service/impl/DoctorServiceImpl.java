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
    public void loadAllDoctors() {
        List<Doctor> listDoctors = doctorDao.loadAllDoctors();
        for (Doctor doc: listDoctors)
        {
            System.out.println(doc.getDoctor_id());
        }
    }

    @Override
    public void getFullNameById(long id) {
        String name = doctorDao.findFullNameById(id);
        System.out.println(name);
    }
}

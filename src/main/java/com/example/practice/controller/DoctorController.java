package com.example.practice.controller;

import com.example.practice.dao.DoctorDao;
import com.example.practice.dao.impl.DoctorDaoImpl;
import com.example.practice.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao;

    @GetMapping("/doctors")
    public String doctors(Model model)
    {
        model.addAttribute("doctors", doctorDao.loadAllDoctors());
        return "doctors";
    }
}

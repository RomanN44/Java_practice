package com.example.practice.controller;

import com.example.practice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public void setDoctorService(DoctorService doctorService) {this.doctorService = doctorService; }

    @GetMapping("/show-doctors")
    public String doctorsMain(Model model)
    {
        model.addAttribute("doctorsList", doctorService.loadAllDoctors());
        return "doctors";
    }
}

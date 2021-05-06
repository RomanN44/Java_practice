package com.example.practice;

import com.example.practice.model.Resource;
import com.example.practice.model.User;
import com.example.practice.service.DoctorService;
import com.example.practice.service.ResourceService;
import com.example.practice.service.impl.UserDetailServiceImpl;
import com.example.practice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@SpringBootApplication
public class JavaPracticeApplication implements CommandLineRunner {
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ResourceService resourceService;

    public static void main(String[] args) {
        SpringApplication.run(JavaPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

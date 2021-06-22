package com.example.practice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.practice.model.Doctor;
import com.example.practice.service.DoctorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {

    @Mock
    private DoctorService doctorService;

    @InjectMocks
    private DoctorController doctorController;

    private MockMvc mockMvc;

    @Before
    public void init() {
        //MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(doctorController).build();
    }

    @Test
    public void doctors() throws Exception {
        List<Doctor> list = new ArrayList<>();
        Doctor doc1 = new Doctor();
        doc1.setDoctor_id(1);
        doc1.setFirst_name("Иван");
        doc1.setSecond_name("Иванов");
        doc1.setPatronymic("Иванович");
        doc1.setSpecialty("Терапевт");
        doc1.setSex(true);
        list.add(doc1);

        when(doctorService.loadAllDoctors()).thenReturn(list);

        mockMvc.perform(get("/show-doctors"))
                .andExpect(status().isOk())
                .andExpect(view().name("doctors"))
                .andExpect(model().attribute("doctorsList", list));
    }

}
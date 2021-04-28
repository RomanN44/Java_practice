package com.example.practice.dao;

import java.util.List;

public interface DoctorDao {
    List loadAllDoctors();
    String findFullNameById(long id);
    String findSpecialtyById(long id);
}

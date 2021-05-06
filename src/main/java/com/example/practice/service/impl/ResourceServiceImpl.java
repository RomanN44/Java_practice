package com.example.practice.service.impl;

import com.example.practice.dao.DoctorDao;
import com.example.practice.dao.ResourceDao;
import com.example.practice.model.Resource;
import com.example.practice.model.ResourceForUsers;
import com.example.practice.service.ResourceService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;
    @Autowired
    private DoctorDao doctorDao;

    @Override
    public List loadAllFreeResources() {
        List<Resource> listResource= resourceDao.loadAllResources();
        return getOpenResources(listResource);
    }

    @Override
    public void bookingResource(long resource_id, long user_id) {
        resourceDao.bookingResource(resource_id, user_id);
    }

    @Override
    public List loadUsersResources(long user_id) {
        List<Resource> listResource= resourceDao.loadUsersResources(user_id);
        List<ResourceForUsers> returnedList = new ArrayList<>();
        long index = 1;
        for (Resource res: listResource)
        {
            returnedList.add(createElement(index, res));
            index++;
        }
        return returnedList;
    }

    private ResourceForUsers createElement(long index, Resource res) {
        ResourceForUsers resourceForUsers = new ResourceForUsers();
        resourceForUsers.setId(res.getResource_id());
        resourceForUsers.setIndex(index);
        resourceForUsers.setDoctor(doctorDao.findFullNameById(res.getDoctor_id()));
        resourceForUsers.setSpecialty(doctorDao.findSpecialtyById(res.getDoctor_id()));
        resourceForUsers.setDate(res.getDate().toString());
        resourceForUsers.setTime(res.getTime().toString());
        return resourceForUsers;
    }

    @Override
    public void clearResource(long resource_id)  {
        resourceDao.clearResource(resource_id);
    }

    @Override
    public List findResource(String first_name, String second_name, String specialty) {
        List<Resource> listResource= resourceDao.findResource(first_name, second_name, specialty);
        return getOpenResources(listResource);
    }

    @NotNull
    private List getOpenResources(List<Resource> listResource) {
        List<ResourceForUsers> returnedList = new ArrayList<>();
        long index = 1;
        for (Resource res: listResource)
        {
            if(res.isOpen()) {
                returnedList.add(createElement(index, res));
                index++;
            }
        }
        return returnedList;
    }
}

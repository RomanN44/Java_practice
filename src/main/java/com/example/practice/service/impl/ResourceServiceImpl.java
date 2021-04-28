package com.example.practice.service.impl;

import com.example.practice.dao.DoctorDao;
import com.example.practice.dao.ResourceDao;
import com.example.practice.model.Resource;
import com.example.practice.model.ResourceForUsers;
import com.example.practice.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<ResourceForUsers> returnedList = new ArrayList<>();
        long index = 1;
        for (Resource res: listResource)
        {
            ResourceForUsers resourceForUsers = new ResourceForUsers();
            resourceForUsers.setId(res.getResource_id());
            resourceForUsers.setIndex(index);
            resourceForUsers.setDoctor(doctorDao.findFullNameById(res.getDoctor_id()));
            resourceForUsers.setSpecialty(doctorDao.findSpecialtyById(res.getDoctor_id()));
            resourceForUsers.setDatetime(res.getDate().toString() + " " + res.getTime().toString());
            if(res.isOpen()) {
                returnedList.add(resourceForUsers);
                index++;
            }
        }
        return returnedList;
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
            ResourceForUsers resourceForUsers = new ResourceForUsers();
            resourceForUsers.setId(res.getResource_id());
            resourceForUsers.setIndex(index);
            resourceForUsers.setDoctor(doctorDao.findFullNameById(res.getDoctor_id()));
            resourceForUsers.setSpecialty(doctorDao.findSpecialtyById(res.getDoctor_id()));
            resourceForUsers.setDatetime(res.getDate().toString() + " " + res.getTime().toString());
            returnedList.add(resourceForUsers);
            index++;
        }
        return returnedList;
    }

    @Override
    public void clearResource(long resource_id)  {
        resourceDao.clearResource(resource_id);
    }
}

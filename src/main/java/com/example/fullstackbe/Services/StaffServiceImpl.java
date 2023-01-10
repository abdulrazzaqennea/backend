package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.Staff;
import com.example.fullstackbe.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;
    @Override
    public Staff addStaff(Staff staff){
        staffRepository.save(staff);
        return staff;
    }
    @Override
    public List<Staff> getStaff(){
        return staffRepository.findAll();
    }
}

package com.example.fullstackbe.Services;

import com.example.fullstackbe.Model.Staff;

import java.util.List;

public interface StaffService {
    public Staff addStaff(Staff staff);
    public List<Staff> getStaff();
}

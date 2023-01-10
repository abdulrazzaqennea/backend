package com.example.fullstackbe.Controller;

import com.example.fullstackbe.Model.Staff;
import com.example.fullstackbe.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @PostMapping("/staff")
    public Staff addStaff(@RequestBody Staff staff){
        return this.staffService.addStaff(staff);
    }
    @GetMapping("/staff")
    public List<Staff> getStaff(){
        return this.staffService.getStaff();
    }
}

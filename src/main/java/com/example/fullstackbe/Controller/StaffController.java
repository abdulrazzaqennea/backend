package com.example.fullstackbe.Controller;

import com.example.fullstackbe.Model.Staff;
import com.example.fullstackbe.Services.StaffService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StaffController {
    Logger logger = LoggerFactory.getLogger(StaffController.class);
    @Autowired
    private StaffService staffService;
    @PostMapping("/addstaff")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Staff addStaff(@Valid @RequestBody Staff staff){
        logger.info("New Staff member added.");
        return this.staffService.addStaff(staff);
    }
    @GetMapping("/getstaff")
    @PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
    public List<Staff> getStaff(){
        return this.staffService.getStaff();
    }
}

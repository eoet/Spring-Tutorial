package com.ifi.controller;

import com.ifi.dto.StaffDTO;
import com.ifi.model.Staff;
import com.ifi.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${staff.api.version}/staffs")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/")
    private List<Staff> getAllStaffs() {
        return staffService.getAllStaffs();
    }

    @GetMapping("/{id}")
    private Staff getStaffById(@PathVariable("id") Long id) {
        return staffService.getStaffById(id);
    }

    @PostMapping("/")
    private Staff saveStaff(@RequestBody StaffDTO dto) {
        try {
            return staffService.saveStaff(dto);
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    private String deleteStaff(@PathVariable("id") Long id) {
        try {
            return staffService.deleteStaff(id);
        } catch (Exception e) {
            return "error";
        }
    }

}

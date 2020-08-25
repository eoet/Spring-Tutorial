package com.ifi.service;

import com.ifi.dto.StaffDTO;
import com.ifi.model.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getAllStaffs();

    Staff getStaffById(Long id);

    Staff saveStaff(StaffDTO dto);

    String deleteStaff(long id) throws Exception;
}

package com.ifi.service;

import com.ifi.dto.StaffDTO;
import com.ifi.model.Staff;
import com.ifi.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaffs() {
        List<Staff> staffList = new ArrayList<Staff>();
        staffRepository.findAll().forEach(staffList::add);
        return staffList;
    }

    public Staff getStaffById(Long id) {
        return staffRepository.findStaffById(id);
    }


    public Staff saveStaff(StaffDTO dto) {
        Staff staff = new Staff();
        staff.setEmail(dto.getEmail());
        staff.setFirstName(dto.getFirstName());
        staff.setLastName(dto.getLastName());
        return staffRepository.save(staff);
    }

    public String deleteStaff(long id) throws Exception {
        boolean existsById = staffRepository.existsById(id);
        if (existsById) {
            staffRepository.deleteById(id);
            return "Success";
        } else {
            throw new Exception("Id not found");
        }
    }
}

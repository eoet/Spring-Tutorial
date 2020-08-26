package com.ifi.service;

import com.ifi.dto.StaffDTO;
import com.ifi.model.Staff;
import com.ifi.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StaffRepository staffRepository;

    public List<Staff> getAllStaffs() {
        logger.info("{} getAllStaffs", this.getClass());
        List<Staff> staffList = new ArrayList<Staff>();
        staffRepository.findAll().forEach(staffList::add);
        return staffList;
    }

    public Staff getStaffById(Long id) {
        logger.info("{} getStaffById", this.getClass());
        return staffRepository.findStaffById(id);
    }


    public Staff saveStaff(StaffDTO dto) {
        logger.info("{} saveStaff", this.getClass());
        Staff staff = new Staff();
        staff.setEmail(dto.getEmail());
        staff.setFirstName(dto.getFirstName());
        staff.setLastName(dto.getLastName());
        return staffRepository.save(staff);
    }

    public String deleteStaff(long id) {
        logger.info("{} deleteStaff", this.getClass());
        boolean existsById = staffRepository.existsById(id);
        if (existsById) {
            staffRepository.deleteById(id);
            return "Success";
        } else {
            throw new RuntimeException("Not found");
        }
    }
}

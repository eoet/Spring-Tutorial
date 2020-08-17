package com.ifi.repositories;

import com.ifi.models.Staff;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StaffRepositoryImpl implements StaffRepository {
    public List<Staff> getAllStaffs() {
        List<Staff> staffList = new ArrayList<Staff>();
        staffList.add(new Staff("Pavel", "31"));
        return staffList;
    }
}

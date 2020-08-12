package com.ifi.repositories;

import java.util.ArrayList;
import java.util.List;

import com.ifi.models.Staff;

public class StaffRepositoryImpl implements StaffRepository{
	public List<Staff> getAllStaffs() {
		List<Staff> staffList = new ArrayList<Staff>();
		staffList.add(new Staff("Pavel", "31"));
		return staffList;
	}
}

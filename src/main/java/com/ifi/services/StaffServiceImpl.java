package com.ifi.services;

import java.util.List;

import com.ifi.models.Staff;
import com.ifi.repositories.StaffRepository;
import com.ifi.repositories.StaffRepositoryImpl;

public class StaffServiceImpl implements StaffService {
	private StaffRepository staffRepository = new StaffRepositoryImpl();

	
	public List<Staff> getAllStaffs() {
		return staffRepository.getAllStaffs();
	}
}

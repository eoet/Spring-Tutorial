package com.ifi;

import java.util.List;

import com.ifi.models.Staff;
import com.ifi.services.StaffService;
import com.ifi.services.StaffServiceImpl;

public class StaffApp {
	
	public static void main(String[] args) {
		 StaffService staffService = new StaffServiceImpl();	
		 List<Staff> allStaffs = staffService.getAllStaffs();
		 System.out.println(allStaffs.size());
		 Staff staff = allStaffs.get(0);
		 System.out.println(staff);
	}
}

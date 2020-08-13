package com.ifi;

import com.ifi.services.StaffService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StaffApp {

    public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		StaffService staffService = ctx.getBean("staffService", StaffService.class);
		System.out.println(staffService.getAllStaffs().size());
		ctx.close();
	}
}

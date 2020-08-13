package com.ifi.iot.main;

import java.util.List;

import com.ifi.iot.db.EmployeeRepository;
import com.ifi.iot.entities.Employee;

public class HibernateMain {
	public static void main(String[] args) {
		EmployeeRepository repo = new EmployeeRepository();
		
		// Get all employee
		List<Employee> listEmployee = repo.fetchAll();
		
		// Create a new employee
		repo.create(new Employee("Hiep 2", 31));
		
		// Update an employee
		Employee firstEmployee = listEmployee.get(0);
		firstEmployee.setName("Hiep update 1");
		repo.update(firstEmployee);
		
		// Delete an employee
		repo.delete(firstEmployee.getId());
	}
}

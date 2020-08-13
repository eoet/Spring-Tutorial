package com.ifi.iot.main;

import java.util.List;

import com.ifi.iot.connection.PosgresqlConnection;
import com.ifi.iot.db.EmployeeRepository;
import com.ifi.iot.entities.Employee;
import com.ifi.iot.utils.IotUtils;

public class JDBCConnection {
	public static void main(String[] args) {
		// Get Connection
		EmployeeRepository empRepo = new EmployeeRepository(new PosgresqlConnection());
		
		// Create Employee
		createEmployee(empRepo, new Employee("Hiep", 31));
		
		// Get all Employee
		List<Employee> listEmployee = getAllEmployee(empRepo);
		
		// Update Employee
		if (!IotUtils.isEmpty(listEmployee)) {
			Employee updatedEmployee = empRepo.update(listEmployee.get(0));
			if (updatedEmployee != null) {
				IotUtils.printVar("A new employee has been updated successfully!", updatedEmployee);
			} else {
				IotUtils.printVar("Cannot update employee by id=1", "");
			}
			IotUtils.printVar("All Employee", listEmployee);
		}
		
		// Delete Employee
		if (!IotUtils.isEmpty(listEmployee)) {
			boolean isDeleted = empRepo.delete(listEmployee.get(0).getId());
			if (isDeleted) {
				IotUtils.printVar("Employee with id=" + listEmployee.get(0).getId() + " has been deleted!!!", listEmployee.get(0));
			} else {
				IotUtils.printVar("Cannot delete employee with id=" + listEmployee.get(0).getId(), "");
			}
			IotUtils.printVar("All Employee", listEmployee);
		}
	}

	private static List<Employee> getAllEmployee(EmployeeRepository empRepo) {
		List<Employee> employees = empRepo.fetchAll();
		IotUtils.printVar("GET all Employee", employees);
		return employees;
	}

	private static void createEmployee(EmployeeRepository empRepo, Employee emp) {
		Employee createdEmployee = empRepo.create(emp);
		if (createdEmployee != null) {
			IotUtils.printVar("A new employee has been created successfully!", createdEmployee);
		} else {
			IotUtils.printVar("Cannot create a new employee", "");
		}
	}
}

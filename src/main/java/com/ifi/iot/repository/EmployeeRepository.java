package com.ifi.iot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ifi.iot.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
	List<Employee> findByName(String name);
}

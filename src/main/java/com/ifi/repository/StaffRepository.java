package com.ifi.repository;

import com.ifi.model.Staff;
import org.springframework.data.repository.CrudRepository;

public interface StaffRepository extends CrudRepository<Staff, Long> {
    Staff findStaffById(Long id);
}

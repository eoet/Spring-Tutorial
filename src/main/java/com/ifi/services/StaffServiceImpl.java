package com.ifi.services;

import com.ifi.models.Staff;
import com.ifi.repositories.StaffRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

public class StaffServiceImpl implements StaffService {
    private StaffRepository staffRepository;

    public StaffServiceImpl() {
        System.out.println("Constructor no-args");
    }

    public StaffServiceImpl(StaffRepository staffRepository) {
        System.out.println("Constructor Injection");
        this.staffRepository = staffRepository;
    }

    public StaffRepository getStaffRepository() {
        return staffRepository;
    }

    public void setStaffRepository(StaffRepository staffRepository) {
        System.out.println("Setter injection");
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaffs() {
        return staffRepository.getAllStaffs();
    }


    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Staff destroy");
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Staff afterPropertiesSet");
    }

//    public void init() {
//        System.out.println("Employee init");
//    }
//
//    public void destroyEmployee() {
//        System.out.println("Employee custom destroy");
//    }
}

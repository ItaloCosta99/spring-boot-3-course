package com.luv2code.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  
}

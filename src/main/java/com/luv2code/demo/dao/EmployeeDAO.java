package com.luv2code.demo.dao;

import java.util.List;

import com.luv2code.demo.entity.Employee;

public interface EmployeeDAO {

  List<Employee> findAll();

  Employee findById(int theId);
  
  Employee save(Employee theEmployee);

  void deleteById(int theId);
  
}
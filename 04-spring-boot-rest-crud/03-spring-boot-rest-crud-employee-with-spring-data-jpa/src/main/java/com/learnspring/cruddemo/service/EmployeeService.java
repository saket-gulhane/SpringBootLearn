package com.learnspring.cruddemo.service;

import com.learnspring.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findALl();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}

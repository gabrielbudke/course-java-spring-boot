package com.luv2code.springboot.restdemo.dao;

import com.luv2code.springboot.restdemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}

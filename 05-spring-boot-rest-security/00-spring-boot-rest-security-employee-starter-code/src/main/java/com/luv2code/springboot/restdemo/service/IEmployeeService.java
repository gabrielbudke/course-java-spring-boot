package com.luv2code.springboot.restdemo.service;

import com.luv2code.springboot.restdemo.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    Employee save(Employee employee);

}

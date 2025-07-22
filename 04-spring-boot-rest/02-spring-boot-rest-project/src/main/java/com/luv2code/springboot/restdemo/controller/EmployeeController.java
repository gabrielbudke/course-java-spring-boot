package com.luv2code.springboot.restdemo.controller;

import com.luv2code.springboot.restdemo.dao.EmployeeDao;
import com.luv2code.springboot.restdemo.entity.Employee;
import com.luv2code.springboot.restdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // expose "/employees" and return a list of employees
    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("{id}")
    public Employee findById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);

        if(employee == null) {
            throw new RuntimeException("Employee didn't find with id " + id);
        }

        return employee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0L);
        return employeeService.save(employee);
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping()
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // add mapping for DELETE /employees
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);

        if(employee == null) {
            throw new RuntimeException("Employee didn't find with id " + id);
        }

        employeeService.deleteById(id);
    }

}

package com.luv2code.springboot.restdemo.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.luv2code.springboot.restdemo.entity.Employee;
import com.luv2code.springboot.restdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    public EmployeeController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
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

    // add mapping for PATCH
    @PatchMapping("{id}")
    public Employee patchEmployee(@PathVariable Long id, @RequestBody Map<String, Object> patchPayload) throws JsonMappingException {

        Employee currentEmployee = employeeService.findById(id);

        // throw exception if null
        if(currentEmployee == null) {
            throw new RuntimeException("Employee didn't find with id " + id);
        }

        //throw exception if request body contains "id" key
        if(patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body");
        }

        Employee patchedEmployee = jsonMapper.updateValue(currentEmployee, patchPayload);

        return employeeService.save(patchedEmployee);
    }

}

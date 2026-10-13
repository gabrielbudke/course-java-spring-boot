package com.luv2code.springboot.restdemo.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.luv2code.springboot.restdemo.entity.Employee;
import com.luv2code.springboot.restdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController()
public class EmployeeController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    public EmployeeController(EmployeeService employeeService, JsonMapper jsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = jsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable  Long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee) {
        employee.setId(0L);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable  Long id) {

        Employee employee = employeeService.findById(id);

        if(employee == null) {
            throw new RuntimeException("Employee not found with id " + id);
        }

        employeeService.deleteById(id);

        return "Employee with id " + id + " has been deleted";
    }

    // add mapping for PATCH
    @PatchMapping("/employees/{id}")
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

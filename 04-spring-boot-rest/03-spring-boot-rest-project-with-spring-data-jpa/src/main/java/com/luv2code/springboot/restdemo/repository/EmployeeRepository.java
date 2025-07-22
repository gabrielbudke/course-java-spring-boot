package com.luv2code.springboot.restdemo.repository;

import com.luv2code.springboot.restdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // that's it ... no need to write any code!
}

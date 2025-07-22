package com.luv2code.restdemo.controller;

import com.luv2code.restdemo.entity.Student;
import com.luv2code.restdemo.exception.StudentErrorResponse;
import com.luv2code.restdemo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        System.out.println("[INFO] - Executando loadData() ...");
        students.add(new Student("John", "Doe"));
        students.add(new Student("Peter", "Dopp"));
        students.add(new Student("Marcus", "Doll"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudentByIndex(@PathVariable int studentId) {

        if(studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student not found with id " + studentId);
        }

        return students.get(studentId);

    }

}

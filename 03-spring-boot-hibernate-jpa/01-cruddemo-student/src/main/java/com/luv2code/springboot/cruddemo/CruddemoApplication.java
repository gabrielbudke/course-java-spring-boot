package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.dao.IStudentDao;
import com.luv2code.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(IStudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
			createMultipleStudents(studentDao);
			readStudentById(studentDao);
			findAllStudents(studentDao);
			findByLastName(studentDao);
			updateStudent(studentDao);
			deleteStudent(studentDao);
			deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(IStudentDao studentDao) {
		// delete all students
		System.out.println("Deleting all students ...");
		int numRowsDeleted = studentDao.deleteAll();

		System.out.println("Deleted row count: " + numRowsDeleted);

	}

	private void deleteStudent(IStudentDao studentDao) {
		int studentId = 3;
		System.out.println("Deleting student with id: " + studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(IStudentDao studentDao) {
		// retrieve student based on the id
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDao.findById(studentId);

		// change last name
		System.out.println("Updating student ...");
		student.setLastName("Doe");

		// update the student
		studentDao.update(student);

		// display updated student
		System.out.println("Updated student: " + student);
	}

	private void findByLastName(IStudentDao studentDao) {
		// get a list of students
		List<Student> students = studentDao.findByLastName("Duck");

		// display a list of students
		students.forEach(System.out::println);
	}

	private void findAllStudents(IStudentDao studentDao) {
		// get a list of students
		List<Student> students = studentDao.findAll();

		// display list of students
		students.forEach(System.out::println);
	}

	private void readStudentById(IStudentDao studentDao) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student student = new Student("Duffy", "Duck", "duffy@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDao.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());

		System.out.println("Retrieving student with id: " + student.getId());
		Student myStudent = studentDao.findById(student.getId());

		System.out.println("Found the student: " + myStudent);


	}

	private void createMultipleStudents(IStudentDao studentDao) {
		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student studentOne = new Student("Bruce", "Banner", "john@luv2code.com");
		Student studentTwo = new Student("Mary", "Public", "mary@luv2code.com");
		Student studentThree = new Student("Peter", "Parker", "peter@luv2code.com");

		// save the student objects
		studentDao.save(studentOne);
		studentDao.save(studentTwo);
		studentDao.save(studentThree);
	}

	private void createStudent(IStudentDao studentDao) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student student = new Student("John", "Doe", "john@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDao.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());
	}

}

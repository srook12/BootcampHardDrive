package com.ssa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eddb.Student;

@CrossOrigin
@RestController
public class TestController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/student")
	public Student student() {
		return new Student("John", "Doe", 1300, 3.6);
	}
	
	@RequestMapping("/students")
	public List<Student> students() {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("A", "Smith", 1000, 3.0));
		students.add(new Student("Greg", "Doud", 1250, 3.5));
		students.add(new Student("Jack", "Bauer", 1175, 3.25));
		students.add(new Student("Ed", "Asner", 1400, 2.9));
		students.add(new Student("Sunny", "Day", 1000, 3.2));
		students.add(new Student("IP", "Daily", 1200, 4.0));
		
		
		return students;
	}
	
	@RequestMapping("/")
}

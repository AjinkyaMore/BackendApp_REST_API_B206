package com.adhyayan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adhyayan.model.Student;
import com.adhyayan.service.StudentServiceI;

@RestController
public class StudentController {

	@Autowired
	StudentServiceI studentServiceI;
	
	@PostMapping("/saveStudent")
	public Student saveStudent(@RequestBody Student s) {
		
		System.out.println("In controller : " +s.getSname());
		studentServiceI.saveStudent(s); //data pass in service
		return s;
	}
	
	@GetMapping("/getAllData")
	public List<Student> getAll() {
		List<Student> allData = studentServiceI.getAllData();
		return allData;
	}
	
	@GetMapping("/getSingleData/{rollno}")
	public Student getSingleData(@PathVariable Integer rollno) {
		
		Student st = studentServiceI.getSingleData(rollno);
		return st;
	}
	
	@DeleteMapping("/deleteByRollno/{rollno}")
	public String deleteData(@PathVariable Integer rollno) {
		studentServiceI.deleteData(rollno);
		return "Data deleted...!! : " +rollno;
	}
	
	@PutMapping("/updateData/{rollno}")
	public Student updataData(@PathVariable Integer rollno, @RequestBody Student s) {
		Student updateStudent = studentServiceI.updateStudent(rollno, s);
		return updateStudent;
	}
	
	@GetMapping("/getStudentByName/{sname}")
	public List<Student> getStudentByName(@PathVariable String sname) {
		List<Student> byName = studentServiceI.getStudentsByName(sname);
		return byName;
	}
	
	@GetMapping("/msg")
	public String m1() {
		
		return "Hello";
	}
}

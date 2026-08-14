package com.adhyayan.service;

import java.util.List;

import com.adhyayan.model.Student;

public interface StudentServiceI {

	public void saveStudent(Student s);
	
	public List<Student> getAllData();
	
	public Student getSingleData(Integer rollno);
	
	public void deleteData(Integer rollno);
	
	public Student updateStudent(Integer rollno, Student s);
	
	public List<Student> getStudentsByName(String sname);
}

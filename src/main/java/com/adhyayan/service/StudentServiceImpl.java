package com.adhyayan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhyayan.model.Student;
import com.adhyayan.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void saveStudent(Student s) {
		System.out.println("In service : " +s.getSname());
		studentRepository.save(s); //pass data in repository
	}

	@Override
	public List<Student> getAllData() {
		
//		List<Student> list = (List<Student>) studentRepository.findAll();
		
		List<Student> list = studentRepository.getAllStudents();
		return list;
	}

	@Override
	public Student getSingleData(Integer rollno) {
		
		Student st = studentRepository.findById(rollno).get();
		return st;
	}

	@Override
	public void deleteData(Integer rollno) {
		
		studentRepository.deleteById(rollno);
	}

	@Override
	public Student updateStudent(Integer rollno, Student s) {
		
		Student existing = studentRepository.findById(rollno).get();
		existing.setSname(s.getSname());
		existing.setMarks(s.getMarks());
		existing.setAddress(s.getAddress());
		studentRepository.save(existing);
		return existing;
	}
	
	@Override
	public List<Student> getStudentsByName(String sname) {
		
		List<Student> bySname = studentRepository.findBySname(sname);
		return bySname;
	}
	
}

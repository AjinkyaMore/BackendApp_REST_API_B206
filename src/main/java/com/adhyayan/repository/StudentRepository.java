package com.adhyayan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adhyayan.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	//find students by name
	public List<Student> findBySname(String sname);
	
	@Query("from Student")
//	@NativeQuery("select * from Student")
	public List<Student> getAllStudents();
}


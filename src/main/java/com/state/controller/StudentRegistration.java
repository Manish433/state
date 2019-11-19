package com.state.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.state.entity.Student;
import com.state.repository.CourseRepository;
import com.state.repository.StudentRepository;

@RestController
public class StudentRegistration {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	

	@DeleteMapping("students/{studentsId}")
	public ResponseEntity<?> deleteStudents(@PathVariable Long studentsId) throws Exception{
		return studentRepo.findById(studentsId).map(students -> {
			studentRepo.delete(students);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("PostId " + studentsId + " not found"));
		
	}
	
	@PostMapping
	public ResponseEntity<?> addStudents(@RequestBody Student student) throws Exception{
		return courseRepo.findById(student.getCourseName().getId()).map(course -> {
			studentRepo.save(student);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new Exception("Course is not valid for courseId" + student.getCourseName().getId() + " not found"));		
	}
}

package com.state.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.state.repository.CourseRepository;
import com.state.repository.StudentRepository;

@RestController
public class CourseRegistration {

	@Autowired
	private CourseRepository courseRepo;
	

	
}

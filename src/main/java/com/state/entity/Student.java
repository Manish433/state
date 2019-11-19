package com.state.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Student implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="STUDENT_ID")
	private long id;
	
	@Column(name="STUDENT_NAME")
	private String name;
	

	@OneToOne(fetch=FetchType.LAZY, optional=false, cascade =  CascadeType.ALL)
	@JoinColumn(name="COURSE_ID")
	@JsonIgnore
	private Course courseName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourseName() {
		return courseName;
	}

	public void setCourseName(Course courseName) {
		this.courseName = courseName;
	}
		
}

package com.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                         // --> used to create table
@Table(name="student")
public class Student {
	@Id                        // -> used to make any field primary Key
	private int id;
	private String name;
	
	@Column(unique=true)
	private String email;
	private int marks;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
        if(marks < 0 || marks > 100)
            throw new IllegalArgumentException("Marks must be 0-100");
        this.marks = marks;
    }
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", marks=" + marks + "]";
	}
	
	
	
}

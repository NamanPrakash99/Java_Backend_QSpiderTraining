package com.oneTomany_Mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="college")
public class College {
	
	@Id
	private int college_id;
	private String name;
	private String location;
	private String pincode;
	
	@OneToMany
	List<Student> student;
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	
	public int getCollege_id() {
		return college_id;
	}
	public void setCollege_id(int college_id) {
		this.college_id = college_id;
	}
	
	public int getId() {
		return college_id;
	}
	public void setId(int college_id) {
		this.college_id = college_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "College [id=" + college_id + ", name=" + name + ", location=" + location + ", pincode=" + pincode + "]";
	}
	
	
	
}

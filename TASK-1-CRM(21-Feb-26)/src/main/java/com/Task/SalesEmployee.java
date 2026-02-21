package com.Task;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SalesEmployee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int empId;
	private String name;
	private String department;
	
	 @OneToMany(mappedBy = "employee")
	 private List<Lead> leads;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "SalesEmployee [empId=" + empId + ", name=" + name + ", department=" + department + ", leads=" + leads
				+ "]";
	}
	
	
}

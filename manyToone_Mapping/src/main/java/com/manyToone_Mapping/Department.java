package com.manyToone_Mapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Department {
	
	@Id
	
	// Sequence also start form 1 but we can assign range 
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "number_sequence")
	@SequenceGenerator(name = "number",sequenceName ="number_sequence", initialValue =  100,allocationSize = 1)
	private int id;
	private String name;
	private String manager_name;
	private int no_of_emp;
	
	
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
	public String getManager_name() {
		return manager_name;
	}
	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}
	public int getNo_of_emp() {
		return no_of_emp;
	}
	public void setNo_of_emp(int no_of_emp) {
		this.no_of_emp = no_of_emp;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", manager_name=" + manager_name + ", no_of_emp=" + no_of_emp
				+ "]";
	}
	
	
}

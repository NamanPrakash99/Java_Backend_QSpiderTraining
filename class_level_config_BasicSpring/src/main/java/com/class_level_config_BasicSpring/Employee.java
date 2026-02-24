package com.class_level_config_BasicSpring;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component                                 // to create a bean 
public class Employee {
	
	@Value("10")                         /// to assign value
	private int id;
	@Value("Alex")
	private String name;
	@Value("20000")
	private int salary;
	
	@Autowired
	private List<String> list;
	
	@Autowired
	private HashMap<Integer,String>map;
	
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
//	}
	
	
}


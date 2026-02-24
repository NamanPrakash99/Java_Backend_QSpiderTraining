package com.class_level_config_BasicSpring;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	// Dependency Injection
//	@Autowired                    // reference should be injected
	private Mobile mobile;       // reference of mobile class-->null, reference

	@Autowired
	private Scanner scan;       // null 
	

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public void message() {
		System.out.println("Hiiiii!!!!");
	}
	
	public Mobile getMobile() {
		return mobile;
	}

//	@Autowired
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}
	
	// constructor
	public Person(Mobile mobile) {
		this.mobile=mobile;
	}

}

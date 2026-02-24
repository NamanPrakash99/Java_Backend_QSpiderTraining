package com.basics_of_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
//		// IOC creating object for the class
//		ApplicationContext ioc =new ClassPathXmlApplicationContext("config.xml");
//		
		// to fetch the data
//		Person person=ioc.getBean("person",Person.class);
//		
//		System.out.println(person);
//		
//		person.message();
		
		
		
		 ApplicationContext ioc=new ClassPathXmlApplicationContext("config.xml");
		 
		 Employee e=ioc.getBean("employee",Employee.class);
		 
		 System.out.println(e);
		 System.out.println(e.getId());
		 System.out.println(e.getName());
		 System.out.println(e.getSalary());
		 
	}
}

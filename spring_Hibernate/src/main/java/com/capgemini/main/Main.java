package com.capgemini.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.ProjectConfiguration;

public class Main {

	// single ton-->one object
	public static void main(String[] args) {
		ApplicationContext ioc=new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		
		
		AnnotationConfigApplicationContext ac=(AnnotationConfigApplicationContext)ioc;
		ac.close();
		
		
//		Employee e1=ioc.getBean(Employee.class);
//		
//		Employee e2=ioc.getBean(Employee.class);
//		
//		e2.setName("Alex");
//		
//		System.out.println(e1);
//		System.out.println(e2);
//		
//		System.out.println(e1==e2);
		
		// to insert
//		EmployeeDao dao = ioc.getBean(EmployeeDao.class);
//		
//		Employee e1 = ioc.getBean(Employee.class);
//        e1.setId(101);
//        e1.setName("Naman");
//        
//        dao.insert(e1);
//        
//        
//        // to find
//        Employee findEmp = dao.findById(101);
//        System.out.println("The name is: " + findEmp.getName());
//        
//        
//        // to update
//        dao.updateById(101, "Naman Prakash");
//        
//        
//        // to delete
//        EmployeeDao delete = ioc.getBean(EmployeeDao.class);
//        dao.deleteByid(101); 
	}
}

package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentMain {
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		StudentDao dao=new StudentDao();
		
		// create
		
		Student s=new Student();
//		s.setId(105);
//		s.setName("Divyansh");
//		s.setMarks(55);
//		s.setEmail("divyansh767@gmail.com");
//		
//		dao.saveStudent(s);
		
		//  to read
		Student find=dao.findStudentById(s.getId());
		
		
		// Update
//		find.setMarks(92);
//        dao.updateStudent(find);
		
		
//		// find
        dao.findAllStudent().forEach(System.out::println);	
//        
//        
//		// Delete
        dao.deleteStudent(find.getId());
		

	}
}

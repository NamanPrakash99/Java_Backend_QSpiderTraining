package com.oneTomany_Mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student s1=new Student();
//		s1.setS_id(103);
//		s1.setBranch("CSE");
//		s1.setName("Naman");
//		
//		Student s2=new Student();
//		s2.setS_id(104);
//		s2.setBranch("MEC");
//		s2.setName("Mohit");
//		
//		College c=new College();
//		
//		c.setCollege_id(2);
//		c.setName("COE");
//		c.setLocation("Delhi");
//		c.setPincode("0001");
//		
//		
//		// Relation and updating the third table
//
//		List<Student> list=new ArrayList();
//		list.add(s2);
//		list.add(s1);
//		
//		c.setStudent(list);
//		
//		
//		et.begin();
//		em.persist(c);
//		em.persist(s1);
//		em.persist(s2);
//		et.commit();
		
		
		StudentDao dao = new StudentDao();
        dao.deleteStudent(101);
		
		
	}
}

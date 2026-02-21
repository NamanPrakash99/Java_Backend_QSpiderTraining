package com.manyTomanyBidirectional;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	     EntityManager em = emf.createEntityManager();
	     EntityTransaction et = em.getTransaction();
	     
	     Student s1=new Student();
	     s1.setId(1);
	     s1.setName("Ravi");
	     s1.setBranch("IT");
	     
	     Student s2=new Student();
	     s2.setId(2);
	     s2.setName("Naman");
	     s2.setBranch("CSE");
	     
	     
	     Subject sub1=new Subject();
	     sub1.setId(101);
	     sub1.setName("Micro-processor");
	     
	     Subject sub2=new Subject();
	     sub2.setId(102);
	     sub2.setName("Machine Learning");
	     
	     
	     Subject sub3=new Subject();
	     sub3.setId(103);
	     sub3.setName("Software Engineer");
	     
	     
	     List<Student> stud=List.of(s1,s2);
	     List<Subject> sub=List.of(sub1,sub2,sub3);
	     
	     // student---> subject
	     s1.setSubject(sub);
	     s2.setSubject(sub);
	     
	     
	     // subject --> student
	     sub1.setStudent(stud);
	     sub2.setStudent(stud);
	     sub3.setStudent(stud);
	     
	     
	     et.begin();
	     em.persist(s1);
	     em.persist(s2);
	     et.commit();
	     
	     em.close();

	}
}

package com.practice;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDao {
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
	EntityManager em=emf.createEntityManager();
	
	// To insert the Data
	
	public void saveStudent(Student s) {
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
	}
	
	
	// to find the data
	
	public Student findStudentById(int id) {
		return em.find(Student.class, id);
		
	}
	
	// to find all
	
	public List<Student> findAllStudent(){
		return em.createQuery("select s from Student s", Student.class).getResultList();
	}
	
	
	// To update Student
	
	public void updateStudent(Student s) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.merge(s);
		et.commit();
	}
	
	
	// to delete Student
	
	public void deleteStudent(int id){
		Student s=em.find(Student.class, id);
		
		if(s!=null) {
			EntityTransaction et=em.getTransaction();
			et.begin();
			em.remove(s);
			et.commit();
		}
	}
	
	
	public List<Student> findStudentsAbove80(){
        return em.createQuery("select s from Student s where s.marks > 80",Student.class)
            .getResultList();
    }
	
	
	
}

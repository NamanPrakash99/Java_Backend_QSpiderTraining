package com.capgemini.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;
import com.capgemini.main.JpaUtil;

@Repository                  // ->does same work as component
public class EmployeeDao {
	
//	@Autowired
//	EntityManager entityManager;
	
	@Autowired
	JpaUtil jpa;
	
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		 em=jpa.getEntityManager();
	}
	
	
	public void insert(Employee e) {
		em.getTransaction().begin();
		
		Employee employee=findById(e.getId());
		
		if(employee==null) {
			em.persist(e);
		}else {
			System.out.println("Data Exist");
		}
		
		em.getTransaction().commit();
	}
	
	public Employee findById(int id) {
		return em.find(Employee.class, id);
	}
	
	public void updateById(int id, String newName) {
		em.getTransaction().begin(); 
		
		Employee e1 = em.find(Employee.class, id);
		
		if (e1 != null) {
			e1.setName(newName); 
		} else {
			System.out.println("Employee not found.");
		}
		
		em.getTransaction().commit(); 
	}
	
	public void deleteByid(int id) {
		
		Employee e2=em.find(Employee.class, id);
		
		em.getTransaction().begin();
		if(e2!=null) {
			em.remove(e2);
		}else {
			System.out.println("Employee not found");
		}
		em   .getTransaction().commit();	
	}
	
}

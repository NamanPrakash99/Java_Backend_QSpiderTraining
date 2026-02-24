package com.capgemini.main;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class JpaUtil {
	
	EntityManagerFactory emf;
	
	EntityManager entityManager;
	
	

	@PostConstruct                 // establish the connection
	public void createConnection() {
		
		emf=Persistence.createEntityManagerFactory("postgres");
		entityManager=emf.createEntityManager();
		
		System.out.println("Connection ");
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	
	
	@PreDestroy                  // close the bean
	public void print() {
		entityManager.close();
		emf.close();
		System.out.println("Closed");
		
	}
	
}

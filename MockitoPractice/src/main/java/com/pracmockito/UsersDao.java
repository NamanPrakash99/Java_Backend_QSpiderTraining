package com.pracmockito;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UsersDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public void insertStudent() {
		Users u = new Users();
		u.setId(1);
		u.setName("Shreya");
		u.setBalance(2000);

		et.begin();
		em.persist(u);
		et.commit();

	}

	public Users findById(int id) {
		return em.find(Users.class, 1);
	}

}

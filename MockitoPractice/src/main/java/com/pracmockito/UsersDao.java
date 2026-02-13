package com.pracmockito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

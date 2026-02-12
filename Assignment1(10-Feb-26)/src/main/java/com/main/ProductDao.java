package com.main;

import javax.persistence.*;
import java.util.List;

public class ProductDao {

	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	    public void insert(Product p){
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        et.begin();
	        em.persist(p);
	        et.commit();
	        em.close();
	    }

	    public void update(Product p){
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        et.begin();
	        em.merge(p);
	        et.commit();
	        em.close();
	    }

	    public Product find(int id){
	        EntityManager em = emf.createEntityManager();
	        return em.find(Product.class, id);
	    }

	    public void delete(int id){
	        EntityManager em = emf.createEntityManager();
	        EntityTransaction et = em.getTransaction();

	        Product p = em.find(Product.class, id);

	        et.begin();
	        em.remove(p);
	        et.commit();
	        em.close();
	    }
}

package com.product;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Demo {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();

        
        // Query for one parameter
//        String jpql = "select p from Product p where p.price>=?1";
//
//        Query query = em.createQuery(jpql);
//        query.setParameter(1, 100.0);
//
//        List<Product> list = query.getResultList();
//
//        list.forEach(i -> System.out.println(i.getName()));
        
        
        
        // -------- FIND BY NAME --------
//        String jpql2 = "select p from Product p where p.name=?1";
//
//        Query q2 = em.createQuery(jpql2);
//        q2.setParameter(1, "Red-Magic");
//
//        List<Product> nameList = q2.getResultList();
//
//        nameList.forEach(p -> System.out.println(p));
        
        
        // Query for two Parameter
        
//        String jpql =
//        	    "select p from Product p where p.price >= ?1 and p.quantity >= ?2";
//
//        	Query query = em.createQuery(jpql);
//
//        	query.setParameter(1, 15.0);
//        	query.setParameter(2, 20);
//
//        	List<Product1> list = query.getResultList();
//
//        	for(Product1 p : list){
//        	    System.out.println(p);
//        	}
        
        
     // using named parameters
        String jpql =
            "select p from Product p where p.price >= :a and p.quantity >= :b";

        Query query = em.createQuery(jpql);

        query.setParameter("a", 15.0);
        query.setParameter("b", 0);

        List<Product> list = query.getResultList();

        for(Product p : list){
            System.out.println(p);
        }

       
    }
      
}

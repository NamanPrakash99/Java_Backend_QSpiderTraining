package com.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductService {
	
	private static final EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
    private static final EntityManager em =emf.createEntityManager();
    
    
    // ADD Product
    public void createProduct(String name,double price) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		Product p=new Product();
    		p.setProdName(name);
    		p.setPrice(price);
    		
    		em.persist(p);
    		et.commit();
    }
    
    
    // READ
    public void getProduct(int id) {
        Product p = em.find(Product.class, id);
        System.out.println(p);
    }
    
    
    // UPDATE PRODUCT
    public void updateProduct(int id,double newPrice){
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		Product p=em.find(Product.class, id);
    		p.setPrice(newPrice);
    		
    		et.commit();
    		System.out.println("Product Updated");
    		
    }
    
    // DELETE PRODUCT
    public void deleteProduct(int id) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		Product p=em.find(Product.class, id);
    		em.remove(p);
    		
    		et.commit();
    		System.out.println("Product deleted");
    }
    
}

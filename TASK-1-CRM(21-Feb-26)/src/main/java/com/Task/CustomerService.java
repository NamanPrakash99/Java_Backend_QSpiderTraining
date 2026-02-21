package com.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerService {

	private static final EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");

    private static final EntityManager em =emf.createEntityManager();
	
	// register customer
	public void registerCustomer(String name,String email,String phone) {
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Customer c=new Customer();
		c.setName(name);
		c.setEmail(email);
		c.setPhone(phone);
	
		em.persist(c);
		et.commit();
		System.out.println("Customer Registered");
	}
	
	
    // READ
    public void getCustomer(int id) {
        Customer c = em.find(Customer.class, id);
        System.out.println(c);
    }

    
	
	// update customer
	public void updateCustomer(int id,String newName) {
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Customer c=em.find(Customer.class, id);
		c.setName(newName);
		
		et.commit();
		System.out.println("Customer Upadted");
	}
	
	
	// delete customer
	public void deleteCustomer(int id) {
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		Customer c=em.find(Customer.class, id);
		em.remove(c);
		
		et.commit();
		System.out.println("Customer Deleted");
	}
}


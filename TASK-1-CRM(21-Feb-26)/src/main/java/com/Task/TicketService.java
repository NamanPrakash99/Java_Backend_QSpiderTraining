package com.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TicketService {
	private static final EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
    private static final EntityManager em =emf.createEntityManager();
    
    // add ticket
    
    public void createTicket(int productId,String issue) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		Product product=em.find(Product.class, productId);
    		
    		SupportTicket ticket=new SupportTicket();
    		ticket.setIssue(issue);
    		ticket.setStatus("OPEN");
    		ticket.setProduct(product);
    		
    		em.persist(ticket);
    		
    		et.commit();
    		System.out.println("Ticket created!!!!");
    }
    

    // READ
    public void getTicket(int id) {
        SupportTicket ticket = em.find(SupportTicket.class, id);
        System.out.println(ticket);
    }
    
    
    // Update
    public void updateTicket(int id,String newStatus) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		SupportTicket ticket=em.find(SupportTicket.class, id);
    		ticket.setStatus(newStatus);
    		
    		et.commit();
    		System.out.println("Ticket Updated");
    }
    
    
    // delete
    
    public void deleteTicket(int id) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		SupportTicket ticket=em.find(SupportTicket.class, id);
    		em.remove(ticket);
    		
    		et.commit();
    		System.out.println("Ticket Deleted!!!!");
    } 
}

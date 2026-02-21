package com.Task;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LeadService {
	private static final EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
    private static final EntityManager em =emf.createEntityManager();
    
    
    // create Lead
    
    public void createLead(String source,String status) {
    		EntityTransaction et = em.getTransaction();
    		
    		et.begin();
    		
    		Lead lead=new Lead();
    		lead.setSource(source);
    		lead.setStatus(status);
    		
    		em.persist(lead);
    		et.commit();
    		System.out.println("Lead Created");
    }
    
    // READ
    public void getLead(int id) {
        Lead lead = em.find(Lead.class, id);
        System.out.println(lead);
    }
    
    
     // Update Ticket
    public void updateLeadStatus(int id,String newStatus) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		Lead lead=em.find(Lead.class, id);
    		lead.setStatus(newStatus);
    		
    		et.commit();
    		System.out.println("Lead updated");
    }
    
    
    // Delete Lead
    public void deleteLead(int id) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		Lead lead=em.find(Lead.class, id);
    		em.remove(lead);
    		
    		et.commit();
    		System.out.println("Lead Deleted");
    }
    
    
    // Assign Leads to employee
    
    public void assignLead(int leadId,int empId) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		Lead lead=em.find(Lead.class, leadId);
    		SalesEmployee emp=em.find(SalesEmployee.class, empId);
    		
    		lead.setEmployee(emp);
    		et.commit();
    		System.out.println("Lead Assigned");
    }
    
    
    // CONVERT LEAD TO CUSTOMER
    
    public void convertLeadToCustomer(int leadId) {

        EntityTransaction et = em.getTransaction();

            // Find Lead
            Lead lead = em.find(Lead.class, leadId);

            // 2Create Customer from Lead data
            Customer customer = new Customer();
            customer.setName("Converted From Lead");
            customer.setEmail("converted@gmail.com");
            customer.setPhone("9999999999");

            // Persist Customer
            em.persist(customer);

            // Remove Lead
            em.remove(lead);

            et.commit();

            System.out.println("Lead Converted to Customer");
    }
    
}

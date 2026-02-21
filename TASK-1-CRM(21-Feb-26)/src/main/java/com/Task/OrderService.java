package com.Task;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderService {
	private static final EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
    private static final EntityManager em =emf.createEntityManager();
    
    
    // Add orders
    public void placeOrder(int customerid, List<Integer> productIds){
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		
    		Customer customer=em.find(Customer.class, customerid);
    		
    		List<Product> products=new ArrayList<>();
    		double total=0;
    		
    		for(Integer id:productIds) {
    			Product p=em.find(Product.class, id);
    			products.add(p);
    			total+=p.getPrice();
    		}
    		
    		Order order=new Order();
    		order.setCustomer(customer);
    		order.setProducts(products);
    		order.setOrderdate("21-02-2026");
    		order.setTotalAmount(total);
    		
    		em.persist(order);
    		
    		et.commit();
    		System.out.println("Order Craeted");
    }
    
    
    // READ
    public void getOrder(int id) {
        Order order = em.find(Order.class, id);
        System.out.println(order);
    }
    
    
    // update Product
    public void updateProduct(int id,String newDate) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		Order order=em.find(Order.class, id);
    		order.setOrderdate(newDate);
    		
    		et.commit();
    		System.out.println("Order Updated");
    }
    
    
    // delete product
    
    public void deleteOrder(int id) {
    		EntityTransaction et=em.getTransaction();
    		
    		et.begin();
    		
    		Order order=em.find(Order.class, id);
    		em.remove(order);
    				
    		et.commit();
    		System.out.println("Order Deleted!!!");
    }
}

package com.Task;


import javax.persistence.*;

public class ReportService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    private static final EntityManager em = emf.createEntityManager();


    // Employee Performance
    public void getEmployeePerformance(int empId) {


            Long count = em.createQuery("SELECT COUNT(l) FROM Lead l WHERE l.employee.empId = ?1",
                    Long.class)
                    .setParameter(1, empId)     //  positional parameter
                    .getSingleResult();

            System.out.println("Total Leads Assigned: " + count);

        
    }



    // Total Orders Per Customer
    public void getCustomerOrderCount(int customerId) {

            Long count = em.createQuery("SELECT COUNT(o) FROM Order o WHERE o.customer.id = ?1",
                    Long.class)
                    .setParameter(1, customerId)
                    .getSingleResult();

            System.out.println("Total Orders: " + count);

        
    }


    // Total Revenue
    public void getTotalRevenue() {

            Double total = em.createQuery("SELECT SUM(o.totalAmount) FROM Order o",
                    Double.class)
                    .getSingleResult();

            System.out.println("Total Revenue: " + total);

    }
}
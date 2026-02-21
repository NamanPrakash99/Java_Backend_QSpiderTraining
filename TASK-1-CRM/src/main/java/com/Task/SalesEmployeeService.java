package com.Task;

import javax.persistence.*;

public class SalesEmployeeService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    private static final EntityManager em = emf.createEntityManager();

    // CREATE
    public void createEmployee(String name, String department) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        SalesEmployee emp = new SalesEmployee();
        emp.setName(name);
        emp.setDepartment(department);

        em.persist(emp);
        tx.commit();

        System.out.println("Employee Created");
    }

    // READ
    public void getEmployee(int id) {
        SalesEmployee emp = em.find(SalesEmployee.class, id);
        System.out.println(emp);
    }

    // DELETE
    public void deleteEmployee(int id) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        SalesEmployee emp = em.find(SalesEmployee.class, id);
        em.remove(emp);

        tx.commit();
        System.out.println("Employee Deleted");
    }
}

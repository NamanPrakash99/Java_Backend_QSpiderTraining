package com.hospital;

import javax.persistence.*;

public class DepartmentService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitalPU");

    public void create(Department d){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(d);
        et.commit();
        em.close();
    }

    public Department getById(Long id){
        EntityManager em = emf.createEntityManager();
        Department d = em.find(Department.class, id);
        em.close();
        return d;
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        Department d = em.find(Department.class, id);
        em.remove(d);
        et.commit();
        em.close();
    }
}

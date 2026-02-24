package com.hospital;

import javax.persistence.*;

public class PrescriptionService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void create(Prescription p){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(p);
        et.commit();
        em.close();
    }

    public Prescription getById(Long id){
        EntityManager em = emf.createEntityManager();
        Prescription p = em.find(Prescription.class, id);
        em.close();
        return p;
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        Prescription p = em.find(Prescription.class, id);
        em.remove(p);
        et.commit();
        em.close();
    }
}

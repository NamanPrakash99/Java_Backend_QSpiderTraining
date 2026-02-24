package com.hospital;

import javax.persistence.*;

public class DoctorService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void create(Doctor d){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(d);
        et.commit();
        em.close();
    }

    public Doctor getById(Long id){
        EntityManager em = emf.createEntityManager();
        Doctor d = em.find(Doctor.class, id);
        em.close();
        return d;
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        Doctor d = em.find(Doctor.class, id);
        em.remove(d);
        et.commit();
        em.close();
    }
}

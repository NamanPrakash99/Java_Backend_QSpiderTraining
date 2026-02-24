package com.hospital;


import javax.persistence.*;

public class PatientService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void create(Patient p){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(p);
        et.commit();
        em.close();
    }

    public Patient getById(Long id){
        EntityManager em = emf.createEntityManager();
        Patient p = em.find(Patient.class, id);
        em.close();
        return p;
    }

    public void update(Long id, String phone){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        Patient p = em.find(Patient.class, id);
        p.setPhone(phone);
        et.commit();
        
        em.close();
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        Patient p = em.find(Patient.class, id);
        em.remove(p);
        et.commit();
        em.close();
    }
}

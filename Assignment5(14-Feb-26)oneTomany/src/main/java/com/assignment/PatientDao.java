package com.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PatientDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void savePatient(Patient p){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(p);
        tx.commit();
        em.close();
    }

    public Patient findPatient(int id){
        return emf.createEntityManager()
                  .find(Patient.class,id);
    }

    public void updatePatient(Patient p){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(p);
        tx.commit();
        em.close();
    }

    public void deletePatient(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Patient p = em.find(Patient.class,id);
        if(p!=null) em.remove(p);
        tx.commit();
        em.close();
    }
}


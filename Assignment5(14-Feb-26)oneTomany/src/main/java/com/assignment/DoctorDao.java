package com.assignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoctorDao {

    private static EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");

    public void saveDoctor(Doctor d){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(d);
        tx.commit();
        em.close();
    }

    public Doctor findDoctor(int id){
        return emf.createEntityManager().find(Doctor.class,id);
    }
}


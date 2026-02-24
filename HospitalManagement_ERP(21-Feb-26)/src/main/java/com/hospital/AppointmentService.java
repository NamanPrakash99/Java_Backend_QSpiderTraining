package com.hospital;

import javax.persistence.*;

public class AppointmentService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void create(Appointment a){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(a);
        et.commit();
        em.close();
    }

    public Appointment getById(Long id){
        EntityManager em = emf.createEntityManager();
        Appointment a = em.find(Appointment.class, id);
        em.close();
        return a;
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        Appointment a = em.find(Appointment.class, id);
        em.remove(a);
        et.commit();
        em.close();
    }
}

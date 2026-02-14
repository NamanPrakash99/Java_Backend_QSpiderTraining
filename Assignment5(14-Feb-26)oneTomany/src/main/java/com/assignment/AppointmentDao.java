package com.assignment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppointmentDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void saveAppointment(Appointment a){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(a);
        tx.commit();
        em.close();
    }

    public List<Appointment> findAppointmentByDoctor(int docId){
        EntityManager em = emf.createEntityManager();

        return em.createQuery("SELECT a FROM Doctor d JOIN d.appointments a WHERE d.id=:id",
            Appointment.class)
            .setParameter("id",docId)
            .getResultList();
    }

    public void updateFee(int id,double fee){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Appointment a = em.find(Appointment.class,id);
        a.setFee(fee);
        tx.commit();
        em.close();
    }
}

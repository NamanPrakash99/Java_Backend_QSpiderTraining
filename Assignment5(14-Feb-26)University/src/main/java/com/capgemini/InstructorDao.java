package com.capgemini;


import javax.persistence.*;

public class InstructorDao {

    private static EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");

    public void saveInstructor(Instructor i){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(i);
        tx.commit();
        em.close();
    }

    public Instructor findInstructor(int id){
        return emf.createEntityManager().find(Instructor.class,id);
    }

    public void updateInstructor(Instructor i){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(i);
        tx.commit();
        em.close();
    }

    public void deleteInstructor(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Instructor i = em.find(Instructor.class,id);
        if(i!=null) em.remove(i);
        tx.commit();
        em.close();
    }
}


package com.capgemini;

import javax.persistence.*;

public class EnrollmentDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void saveEnrollment(Enrollment e){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(e);
        tx.commit();
        em.close();
    }

    public void updateGrade(int id,String grade){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Enrollment e = em.find(Enrollment.class,id);
        if(e!=null) e.setGrade(grade);
        tx.commit();
        em.close();
    }
}


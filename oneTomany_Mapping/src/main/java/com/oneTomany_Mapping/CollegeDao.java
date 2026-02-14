package com.oneTomany_Mapping;

import javax.persistence.*;

public class CollegeDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    // CREATE
    public void saveCollege(College c){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(c);
        et.commit();
        em.close();
    }

    // READ
    public College getCollege(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(College.class, id);
    }

    // UPDATE
    public void updateCollege(int id, String location){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        College c = em.find(College.class, id);

        et.begin();
        c.setLocation(location);
        et.commit();
        em.close();
    }

    // DELETE
    public void deleteCollege(int id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        College c = em.find(College.class, id);

        et.begin();
        em.remove(c);
        et.commit();
        em.close();
    }
}


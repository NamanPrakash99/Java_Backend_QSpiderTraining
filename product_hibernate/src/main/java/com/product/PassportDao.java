package com.product;

import javax.persistence.*;

public class PassportDao {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    EntityManager em = emf.createEntityManager();

    public String insertPassport(Passport p) {
        if (p == null) return "Illegal Argument";

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();

        return "Data Inserted";
    }

    public Passport findById(int id) {
        Passport p = em.find(Passport.class, id);

        if (p != null)
            return p;
        else
            throw new IllegalArgumentException("Passport not found");
    }

    public void update(Passport p) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(p);
        et.commit();
    }

    public String deleteById(int id) {
        Passport p = findById(id);

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(p);
        et.commit();

        return "Deleted";
    }
}


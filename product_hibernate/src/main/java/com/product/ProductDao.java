package com.product;

import javax.persistence.*;

public class ProductDao {

    EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");

    EntityManager em = emf.createEntityManager();

    public String insertProduct(Product p) {
        EntityTransaction et = em.getTransaction();

        if (p != null) {
            et.begin();
            em.persist(p);
            et.commit();
            return "Data Inserted";
        }
        return "Illegal Argument";
    }

    public Product findById(int id) {
        Product p = em.find(Product.class, id);

        if (p != null) return p;
        else throw new IllegalArgumentException("Product not found");
    }

    public void update(Product p) {
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.merge(p);
        et.commit();
    }

    public String deleteById(int id) {
        Product p = findById(id);

        if (p != null) {
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(p);
            et.commit();
            return "Deleted";
        }
        throw new IllegalArgumentException("Not found");
    }
}

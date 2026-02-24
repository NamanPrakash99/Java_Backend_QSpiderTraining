package com.hospital;

import javax.persistence.*;

public class MedicalRecordService {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    public void create(MedicalRecord mr){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        em.persist(mr);
        et.commit();
        em.close();
    }

    public MedicalRecord getById(Long id){
        EntityManager em = emf.createEntityManager();
        MedicalRecord mr = em.find(MedicalRecord.class, id);
        em.close();
        return mr;
    }

    public void delete(Long id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        et.begin();
        
        MedicalRecord mr = em.find(MedicalRecord.class, id);
        em.remove(mr);
        et.commit();
        em.close();
    }
}

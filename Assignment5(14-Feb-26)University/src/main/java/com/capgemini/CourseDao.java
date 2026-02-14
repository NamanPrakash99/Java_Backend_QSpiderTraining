package com.capgemini;


import javax.persistence.*;
import java.util.List;

public class CourseDao {

    private static EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");

    public void saveCourse(Course c){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(c);
        tx.commit();
        em.close();
    }

    public Course findCourse(int id){
        return emf.createEntityManager().find(Course.class,id);
    }

    public List<Course> findByInstructor(int id){
        return emf.createEntityManager()
          .createQuery("SELECT c FROM Instructor i JOIN i.courses c WHERE i.id=:id",Course.class)
          .setParameter("id",id)
          .getResultList();
    }
}


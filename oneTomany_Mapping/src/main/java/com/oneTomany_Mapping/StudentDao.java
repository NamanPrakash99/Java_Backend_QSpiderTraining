package com.oneTomany_Mapping;

import javax.persistence.*;

public class StudentDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

    // CREATE
    public void saveStudent(Student s){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(s);
        et.commit();
        em.close();
    }

    // READ
    public Student getStudent(int id){
        EntityManager em = emf.createEntityManager();
        return em.find(Student.class, id);
    }

    // UPDATE
    public void updateStudent(int id, String newName){
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Student s = em.find(Student.class, id);

        et.begin();
        s.setName(newName);
        et.commit();
        em.close();
    }

    public void deleteStudent(int studentId){

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        // 1) Delete from join table
        Query q1 = em.createNativeQuery("DELETE FROM college_student_det WHERE student_s_id = ?1");
        q1.setParameter(1, studentId);
        q1.executeUpdate();

        // 2) Delete from student table
        Query q2 = em.createNativeQuery("DELETE FROM student_det WHERE s_id = ?1");
        q2.setParameter(1, studentId);
        q2.executeUpdate();

        et.commit();
        em.close();

     }

}


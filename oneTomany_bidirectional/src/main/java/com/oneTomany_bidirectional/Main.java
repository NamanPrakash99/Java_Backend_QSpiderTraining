package com.oneTomany_bidirectional;

import java.util.Arrays;
import javax.persistence.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        
        College c = new College();
        c.setId(1);
        c.setName("LPU");


        Student s1 = new Student();
        s1.setId(101);
        s1.setName("Naman");
        s1.setCourse("CSE");

        Student s2 = new Student();
        s2.setId(102);
        s2.setName("Rahul");
        s2.setCourse("IT");


        s1.setCollege(c);
        s2.setCollege(c);

        c.setStudents(Arrays.asList(s1, s2));


        et.begin();
        em.persist(c); 
        et.commit();


    }
}

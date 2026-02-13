package com.assignment;

import javax.persistence.*;

public class Main{

    public static void main(String[] args) {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // ---------- SAVE ----------
        et.begin();

        AadharCard a = new AadharCard();
        a.setAadharId(1);
        a.setAadharNumber("1234-5678");
        a.setAddress("Delhi");
        a.setIssueDate("2022");

        HostelRoom h = new HostelRoom();
        h.setRoomId(101);
        h.setRoomNumber("A101");
        h.setBlockName("A Block");
        h.setFloorNumber(1);

        em.persist(a);
        em.persist(h);

        Studentuser s = new Studentuser();
        s.setStudentId(10);
        s.setName("Rahul");
        s.setEmail("rahul@gmail.com");
        s.setBranch("CSE");
        s.setAadharCard(a);
        s.setHostelRoom(h);

        em.persist(s);

        et.commit();
        
        

        // ---------- FETCH ----------
        Studentuser fetch = em.find(Studentuser.class, 10);

        System.out.println("Student: " + fetch.getName());
        System.out.println("Aadhar: " + fetch.getAadharCard().getAadharNumber());
        System.out.println("Room: " + fetch.getHostelRoom().getRoomNumber());
        
        

        // ---------- DELETE ----------
        
        et.begin();

        Studentuser del = em.find(Studentuser.class, 10);
        em.remove(del);

        et.commit();

        em.close();
        emf.close();
    }
}

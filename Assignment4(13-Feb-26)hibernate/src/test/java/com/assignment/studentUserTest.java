package com.assignment;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.*;

import org.junit.jupiter.api.*;

public class studentUserTest {

    static EntityManagerFactory emf;
    EntityManager em;
    EntityTransaction et;

    @BeforeAll
    static void setupFactory() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    void setup() {
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @AfterEach
    void close() {
        em.close();
    }

    @AfterAll
    static void closeFactory() {
        emf.close();
    }

    // ---------- CREATE ----------
    @Test
    public void createStudent() {

        et.begin();

        AadharCard a = new AadharCard();
        a.setAadharId(1);
        a.setAadharNumber("1234");
        a.setAddress("Delhi");
        a.setIssueDate("2023");

        HostelRoom h = new HostelRoom();
        h.setRoomId(101);
        h.setRoomNumber("A101");
        h.setBlockName("A");
        h.setFloorNumber(1);

        em.persist(a);
        em.persist(h);

        Studentuser s = new Studentuser();
        s.setStudentId(10);
        s.setName("Rahul");
        s.setEmail("r@gmail.com");
        s.setBranch("CSE");
        s.setAadharCard(a);
        s.setHostelRoom(h);

        em.persist(s);

        et.commit();

        assertNotNull(em.find(Studentuser.class, 10));
    }

    // ---------- FETCH ----------
    @Test
    public void fetchStudent() {

        Studentuser s = em.find(Studentuser.class, 10);

        assertNotNull(s);
        assertEquals("Rahul", s.getName());
    }

    // ---------- DELETE ----------
    
    @Test
    public void deleteStudent() {

        et.begin();

        Studentuser s = em.find(Studentuser.class, 10);
        if (s != null) {
            em.remove(s);
        }

        et.commit();

        assertNull(em.find(Studentuser.class, 10));
        assertNotNull(em.find(AadharCard.class, 1));
        assertNotNull(em.find(HostelRoom.class, 101));
    }
}

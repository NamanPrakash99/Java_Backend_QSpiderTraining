package com.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.product.Person;
import com.product.PersonDao;


public class PersonDaoTest {

    PersonDao dao;

    @BeforeEach
    void setup() {
        dao = new PersonDao();
    }

    // INSERT SUCCESS
    @Test
    void insertTest() {
        Person p = new Person();
        p.setId(10);
        p.setName("Test");
        p.setDob("01-01-2000");
        p.setAddress("Delhi");
        p.setPincode(110001);

        assertEquals("Data Inserted", dao.insertPerson(p));
    }

    // INSERT NULL
    @Test
    void insertNullTest() {
        assertEquals("Illegal Argument", dao.insertPerson(null));
    }

    // FIND SUCCESS
    @Test
    void findTest() {
        Person p = new Person();
        p.setId(20);
        p.setName("FindUser");
        p.setDob("02-02-2002");
        p.setAddress("Mumbai");
        p.setPincode(400001);

        dao.insertPerson(p);

        assertNotNull(dao.findById(20));
    }

    // FIND FAIL
    @Test
    void findExceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> dao.findById(100));
    }

    // UPDATE
    @Test
    void updateTest() {
        Person p = new Person();
        p.setId(30);
        p.setName("Old");
        p.setDob("03-03-2003");
        p.setAddress("Pune");
        p.setPincode(411001);

        dao.insertPerson(p);

        p.setName("Updated");
        dao.update(p);

        assertEquals("Updated", dao.findById(30).getName());
    }

    // DELETE SUCCESS
    @Test
    void deleteTest() {
        Person p = new Person();
        p.setId(40);
        p.setName("Delete");
        p.setDob("04-04-2004");
        p.setAddress("Chennai");
        p.setPincode(600001);

        dao.insertPerson(p);

        assertEquals("Deleted", dao.deleteById(40));
    }

    // DELETE FAIL
    @Test
    void deleteExceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> dao.deleteById(100));
    }
}


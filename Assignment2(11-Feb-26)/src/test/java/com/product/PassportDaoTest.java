package com.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import com.product.Passport;
import com.product.PassportDao;


public class PassportDaoTest {

    PassportDao dao;

    @BeforeEach
    void setup() {
        dao = new PassportDao();
    }

    @Test
    void insertTest() {
        Passport p = new Passport();
        p.setPassportNo(1);
        p.setName("Test");
        p.setGender("Male");
        p.setAddress("Delhi");
        p.setNoOfTravel(2);

        assertEquals("Data Inserted", dao.insertPassport(p));
    }

    @Test
    void insertNullTest() {
        assertEquals("Illegal Argument",
                dao.insertPassport(null));
    }

    @Test
    void findTest() {
        Passport p = new Passport();
        p.setPassportNo(2);
        p.setName("FindUser");
        p.setGender("Female");
        p.setAddress("Mumbai");
        p.setNoOfTravel(5);

        dao.insertPassport(p);

        assertNotNull(dao.findById(2));
    }

    @Test
    void findExceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> dao.findById(999));
    }

    @Test
    void updateTest() {
        Passport p = new Passport();
        p.setPassportNo(3);
        p.setName("Old");
        p.setGender("Male");
        p.setAddress("Pune");
        p.setNoOfTravel(1);

        dao.insertPassport(p);

        p.setName("Updated");
        dao.update(p);

        assertEquals("Updated",
                dao.findById(3).getName());
    }

    @Test
    void deleteTest() {
        Passport p = new Passport();
        p.setPassportNo(4);
        p.setName("Delete");
        p.setGender("Male");
        p.setAddress("Chennai");
        p.setNoOfTravel(4);

        dao.insertPassport(p);

        assertEquals("Deleted",
                dao.deleteById(4));
    }

    @Test
    void deleteExceptionTest() {
        assertThrows(IllegalArgumentException.class,
                () -> dao.deleteById(777));
    }
}


package com.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentDaoTest {

	static EntityManagerFactory emf;
	EntityManager em;
	StudentDao dao;

	@BeforeAll
    static void initEmf() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    void initEm() {
        em = emf.createEntityManager();
    }

	// Insert Test

	@Test
	void saveStudentTest() {
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setId(106);
		s.setName("Shreya");
		s.setMarks(90);
		s.setEmail("shreya976@gmail.com");

		dao.saveStudent(s);
		assertTrue(s.getId() > 0);
	}

	// FindById

	@Test
	void findStudentByIdTest() {
		StudentDao dao = new StudentDao();

		Student s = new Student();
		s.setName("Rahul");
		s.setEmail("rahul@gmail.com");
		s.setMarks(70);

		dao.saveStudent(s);
		Student found = dao.findStudentById(s.getId());
		assertNotNull(found);
	}

	// find Id null
	@Test
	void findbyIdNull() {
		StudentDao dao = new StudentDao();

		assertNull(dao.findStudentById(1000));
	}

	// Find All
	@Test
	void findAllTest() {
		StudentDao dao = new StudentDao();

		Student s = new Student();
		s.setId(107);
		s.setName("srishti");
		s.setMarks(89);
		s.setEmail("srishti876@gmail.com");

		dao.saveStudent(s);

		assertFalse(dao.findAllStudent().isEmpty());
	}

	// Update
	@Test
	void updateTest() {
		StudentDao dao = new StudentDao();

		Student s = new Student();
		s.setId(106);
		s.setName("Shreya");
		s.setMarks(50);
		s.setEmail("shreya9767@gmail.com");

		dao.saveStudent(s);

		s.setMarks(90);
		dao.updateStudent(s);

		assertEquals(90, dao.findStudentById(s.getId()).getMarks());

	}

	// Delete
	@Test
	void deleteStudentTest() {

		StudentDao dao = new StudentDao();

		Student s = new Student();
		s.setId(106);
		s.setName("Shreya");
		s.setMarks(50);
		s.setEmail("shreya976@gmail.com");

		dao.saveStudent(s);

		int id = s.getId();

		dao.deleteStudent(id);

		assertNull(dao.findStudentById(id));
	}
	
	@Test
    void StudentsAboveEightyTest(){
        Student s = new Student();
        s.setName("Topper");
        s.setEmail("top@gmail.com");
        s.setMarks(95);
        dao.saveStudent(s);

        List<Student> list = dao.findStudentsAbove80();
        assertTrue(list.size() > 0);
    }

	@AfterAll
	static void close() {
		emf.close();
	}

}

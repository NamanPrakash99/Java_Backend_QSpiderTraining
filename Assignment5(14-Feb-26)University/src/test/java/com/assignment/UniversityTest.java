package com.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import com.capgemini.*;

public class UniversityTest {

    InstructorDao instructorDAO = new InstructorDao();
    EnrollmentDao enrollmentDAO = new EnrollmentDao();

    // OneToOne

    @Test
    void oneToOneTest(){

        InstructorProfile p = new InstructorProfile();
        p.setId(1);
        p.setOfficeRoom("A101");
        p.setPhone("999");

        Instructor i = new Instructor();
        i.setId(1);
        i.setName("Dr Smith");
        i.setDepartment("CS");
        i.setProfile(p);

        instructorDAO.saveInstructor(i);

        Instructor db = instructorDAO.findInstructor(1);

        assertEquals("A101",db.getProfile().getOfficeRoom());
    }


    // OneToMany

    @Test
    void oneToManyTest(){

        Course c1 = new Course();
        c1.setId(10);
        c1.setTitle("Java");
        c1.setCredits(4);

        Course c2 = new Course();
        c2.setId(11);
        c2.setTitle("DB");
        c2.setCredits(3);

        Instructor i = new Instructor();
        i.setId(2);
        i.setName("Dr John");
        i.setDepartment("IT");
        i.setCourses(List.of(c1,c2));

        instructorDAO.saveInstructor(i);

        assertEquals(2,
            instructorDAO.findInstructor(2)
                .getCourses().size());
    }



    // ManyToOne 

    @Test
    void manyToOneTest(){

        Course c = new Course();
        c.setId(20);
        c.setTitle("AI");
        c.setCredits(5);

        Enrollment e = new Enrollment();
        e.setId(1);
        e.setSemester("Fall");
        e.setGrade("A");
        e.setCourse(c); 

        enrollmentDAO.saveEnrollment(e);

        assertNotNull(e.getCourse());
    }
}

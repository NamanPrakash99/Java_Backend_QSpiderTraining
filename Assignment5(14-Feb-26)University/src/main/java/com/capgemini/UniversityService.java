package com.capgemini;


import java.util.List;

public class UniversityService {

    InstructorDao instructorDao = new InstructorDao();
    CourseDao courseDao = new CourseDao();
    EnrollmentDao enrollmentDao = new EnrollmentDao();

    public void createInstructor(Instructor i){
        instructorDao.saveInstructor(i);
    }

    public void addCourses(int instructorId,List<Course> list){
        Instructor i = instructorDao.findInstructor(instructorId);
        i.setCourses(list);
        instructorDao.updateInstructor(i);
    }

    public void addEnrollment(Enrollment e){
        enrollmentDao.saveEnrollment(e);
    }

    public void updateGrade(int id,String grade){
        enrollmentDao.updateGrade(id,grade);
    }

    public Instructor fetchInstructor(int id){
        return instructorDao.findInstructor(id);
    }

    public void deleteInstructor(int id){
        instructorDao.deleteInstructor(id);
    }
}


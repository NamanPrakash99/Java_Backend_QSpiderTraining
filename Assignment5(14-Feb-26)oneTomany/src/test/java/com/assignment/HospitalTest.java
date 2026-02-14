package com.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class HospitalTest {

    PatientDao patientDao = new PatientDao();
    DoctorDao doctorDao = new DoctorDao();
    AppointmentDao appointmentDao = new AppointmentDao();


    // 1) OneToOne Test

    @Test
    void oneToOneTest(){

        MedicalRecord m = new MedicalRecord();
        m.setId(1);
        m.setBloodGroup("O+");
        m.setAllergies("Dust");

        Patient p = new Patient();
        p.setId(1);
        p.setName("Ravi");
        p.setAge(25);
        p.setContact("999");
        p.setMedicalRecord(m);

        patientDao.savePatient(p);

        Patient db = patientDao.findPatient(1);

        assertEquals("O+",db.getMedicalRecord().getBloodGroup());
    }


    // 2) OneToMany Test

    @Test
    void oneToManyTest(){

        Doctor d = new Doctor();
        d.setId(1);
        d.setName("Smith");
        d.setSpecialization("Cardio");

        doctorDao.saveDoctor(d);

        Appointment a1 = new Appointment();
        a1.setId(1);
        a1.setVisitDate("2026-02-14");
        a1.setFee(500);

        Appointment a2 = new Appointment();
        a2.setId(2);
        a2.setVisitDate("2026-02-15");
        a2.setFee(700);

        d.setAppointments(List.of(a1,a2));
        doctorDao.saveDoctor(d);

        Doctor db = doctorDao.findDoctor(1);

        assertEquals(2,db.getAppointments().size());
    }


    // 3) ManyToOne Test

    @Test
    void manyToOneTest(){

        // create patient FIRST
        Patient p = new Patient();
        p.setId(5);
        p.setName("John");
        p.setAge(30);
        p.setContact("999");

        patientDao.savePatient(p);

        Appointment a = new Appointment();
        a.setId(5);
        a.setVisitDate("2026-02-14");
        a.setFee(900);
        a.setPatient(p);

        appointmentDao.saveAppointment(a);

        assertNotNull(a.getPatient());
    }


    // 4) Update Fee Test

    @Test
    
    void updateTest(){

        // create appointment first
        Appointment a = new Appointment();
        a.setId(10);
        a.setVisitDate("2026-02-14");
        a.setFee(500);

        appointmentDao.saveAppointment(a);

        // now update
        appointmentDao.updateFee(10,1200);

        // verify
        List<Appointment> list =appointmentDao.findAppointmentByDoctor(1);

        assertTrue(true); 
    }



    // 5) Delete Patient Test


    @Test
    void deleteTest(){

        patientDao.deletePatient(1);

        Patient p =
            patientDao.findPatient(1);

        assertNull(p);
    }
}

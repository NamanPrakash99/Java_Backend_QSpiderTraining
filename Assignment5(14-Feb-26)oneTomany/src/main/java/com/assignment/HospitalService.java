package com.assignment;

import java.util.List;

public class HospitalService {

    private PatientDao patientDAO = new PatientDao();
    private DoctorDao doctorDAO = new DoctorDao();
    private AppointmentDao appointmentDAO = new AppointmentDao();

    // Register patient
    public void registerPatient(Patient p){
        patientDAO.savePatient(p);
    }

    // Add appointments to doctor
    public void addAppointments(int doctorId, List<Appointment> appointments){
        Doctor d = doctorDAO.findDoctor(doctorId);

        if(d != null){
            d.setAppointments(appointments);
            doctorDAO.saveDoctor(d);
        } else {
            System.out.println("Doctor not found");
        }
    }

    // Assign patient to appointment
    public void assignPatient(Appointment a, int patientId){
        Patient p = patientDAO.findPatient(patientId);

        if(p != null){
            a.setPatient(p);
            appointmentDAO.saveAppointment(a);
        } else {
            System.out.println("Patient not found");
        }
    }

    // Update fee
    public void updateFee(int appointmentId,double fee){
        appointmentDAO.updateFee(appointmentId,fee);
    }

    // Fetch doctor
    public Doctor fetchDoctor(int id){
        return doctorDAO.findDoctor(id);
    }

    // Delete patient
    public void deletePatient(int id){
        patientDAO.deletePatient(id);
    }
}

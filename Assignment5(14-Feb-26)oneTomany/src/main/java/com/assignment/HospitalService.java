package com.assignment;

import java.util.List;

public class HospitalService {

    PatientDao patientDAO = new PatientDao();
    DoctorDao doctorDAO = new DoctorDao();
    AppointmentDao appointmentDAO = new AppointmentDao();

    public void registerPatient(Patient p){
        patientDAO.savePatient(p);
    }

    public void addAppointments(int docId,List<Appointment> list){
        Doctor d = doctorDAO.findDoctor(docId);
        d.setAppointments(list);
        doctorDAO.saveDoctor(d);
    }

    public void assignPatient(Appointment a,Long pid){
        Patient p = patientDAO.findPatient(pid);
        a.setPatient(p);
        appointmentDAO.saveAppointment(a);
    }

    public void updateFee(Long id,double fee){
        appointmentDAO.updateFee(id,fee);
    }

    public Doctor fetchDoctor(int id){
        return doctorDAO.findDoctor(id);
    }

    public void deletePatient(Long id){
        patientDAO.deletePatient(id);
    }
}

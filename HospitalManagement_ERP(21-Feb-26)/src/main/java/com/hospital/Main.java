package com.hospital;

import java.time.*;

public class Main {

    public static void main(String[] args) {

        PatientService patientService = new PatientService();

        MedicalRecord mr = new MedicalRecord();
        mr.setRecordDate(LocalDate.now());
        mr.setDiagnosis("Flu");
        mr.setNotes("Rest 3 days");

        Patient p = new Patient();
        p.setName("John");
        p.setDob(LocalDate.of(2000,1,1));
        p.setBloodGroup("O+");
        p.setPhone("9876567898");
        p.setMedicalRecord(mr);

        patientService.create(p);

    }
}

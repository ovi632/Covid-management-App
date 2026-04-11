package com.example.covidmanagementapp.Ashraf;

import java.time.LocalDate;

public class Prescription {
    private String patientName , medicineName , dosage , instructions;
    private int registrationId , duration , doctorId;
    private LocalDate createdDate;

    public Prescription(String patientName, String medicineName, String dosage, String instructions, int registrationId, int duration, int doctorId, LocalDate createdDate) {
        this.patientName = patientName;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.instructions = instructions;
        this.registrationId = registrationId;
        this.duration = duration;
        this.doctorId = doctorId;
        this.createdDate = createdDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "patientName='" + patientName + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", instructions='" + instructions + '\'' +
                ", registrationId=" + registrationId +
                ", duration=" + duration +
                ", doctorId=" + doctorId +
                ", createdDate=" + createdDate +
                '}';
    }

}

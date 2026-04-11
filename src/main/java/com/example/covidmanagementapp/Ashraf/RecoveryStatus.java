package com.example.covidmanagementapp.Ashraf;

import java.time.LocalDate;

public class RecoveryStatus {
    private String patientName , recoveryStatus ,doctorNotes;
    private int registrationId , doctorId ;
    private LocalDate statusUpdateDate;

    public RecoveryStatus(String patientName, String recoveryStatus, String doctorNotes, int registrationId, int doctorId, LocalDate statusUpdateDate) {
        this.patientName = patientName;
        this.recoveryStatus = recoveryStatus;
        this.doctorNotes = doctorNotes;
        this.registrationId = registrationId;
        this.doctorId = doctorId;
        this.statusUpdateDate = statusUpdateDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getRecoveryStatus() {
        return recoveryStatus;
    }

    public void setRecoveryStatus(String recoveryStatus) {
        this.recoveryStatus = recoveryStatus;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getStatusUpdateDate() {
        return statusUpdateDate;
    }

    public void setStatusUpdateDate(LocalDate statusUpdateDate) {
        this.statusUpdateDate = statusUpdateDate;
    }

    @Override
    public String toString() {
        return "RecoveryStatus{" +
                "patientName='" + patientName + '\'' +
                ", recoveryStatus='" + recoveryStatus + '\'' +
                ", doctorNotes='" + doctorNotes + '\'' +
                ", registrationId=" + registrationId +
                ", doctorId=" + doctorId +
                ", statusUpdateDate=" + statusUpdateDate +
                '}';
    }
}

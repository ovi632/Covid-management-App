package com.example.covidmanagementapp.Ashraf;

import java.time.LocalDate;

public class CovidStatus {
    private String patientName , newCovidStatus , doctorNotes ;
    private int doctorId , registrationId; ;
    private LocalDate statusUpdateDate;

    public CovidStatus(String patientName, String newCovidStatus, String doctorNotes, int doctorId, int registrationId, LocalDate statusUpdateDate) {
        this.patientName = patientName;
        this.newCovidStatus = newCovidStatus;
        this.doctorNotes = doctorNotes;
        this.doctorId = doctorId;
        this.registrationId = registrationId;
        this.statusUpdateDate = statusUpdateDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getNewCovidStatus() {
        return newCovidStatus;
    }

    public void setNewCovidStatus(String newCovidStatus) {
        this.newCovidStatus = newCovidStatus;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getStatusUpdateDate() {
        return statusUpdateDate;
    }

    public void setStatusUpdateDate(LocalDate statusUpdateDate) {
        this.statusUpdateDate = statusUpdateDate;
    }

    @Override
    public String toString() {
        return "CovidStatus{" +
                "patientName='" + patientName + '\'' +
                ", newCovidStatus='" + newCovidStatus + '\'' +
                ", doctorNotes='" + doctorNotes + '\'' +
                ", doctorId=" + doctorId +
                ", registrationId=" + registrationId +
                ", statusUpdateDate=" + statusUpdateDate +
                '}';
    }
}

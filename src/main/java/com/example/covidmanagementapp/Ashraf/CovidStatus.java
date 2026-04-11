package com.example.covidmanagementapp.Ashraf;

import java.io.Serializable;

public class CovidStatus implements Serializable {

    private int patientId;
    private String previousStatus;
    private String newStatus;
    private String date;
    private String doctorNotes;
    private int doctorId;

    public CovidStatus(int patientId, String previousStatus, String newStatus, String date, String doctorNotes, int doctorId) {
        this.patientId = patientId;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.date = date;
        this.doctorNotes = doctorNotes;
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(String previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "CovidStatus{" +
                "patientId=" + patientId +
                ", previousStatus='" + previousStatus + '\'' +
                ", newStatus='" + newStatus + '\'' +
                ", date='" + date + '\'' +
                ", doctorNotes='" + doctorNotes + '\'' +
                ", doctorId=" + doctorId +
                '}';
    }
}

package com.example.covidmanagementapp.Ashraf;

import java.io.Serializable;

public class RecoveryStatus implements Serializable {

    private int patientId;
    private String patientName;
    private String status;
    private String notes;
    private String date;
    private int doctorId;

    public RecoveryStatus(int patientId, String patientName, String status, String notes, String date, int doctorId) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.status = status;
        this.notes = notes;
        this.date = date;
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "RecoveryStatus{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", status='" + status + '\'' +
                ", notes='" + notes + '\'' +
                ", date='" + date + '\'' +
                ", doctorId=" + doctorId +
                '}';
    }
}

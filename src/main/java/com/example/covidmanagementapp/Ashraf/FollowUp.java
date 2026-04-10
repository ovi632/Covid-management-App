package com.example.covidmanagementapp.Ashraf;

import java.io.Serializable;

public class FollowUp implements Serializable {

    private int patientId;
    private String patientName;
    private int doctorId;
    private String date;
    private String time;
    private String note;

    public FollowUp(int patientId, String patientName, int doctorId, String date, String time, String note) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.note = note;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FollowUp{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", doctorId=" + doctorId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}

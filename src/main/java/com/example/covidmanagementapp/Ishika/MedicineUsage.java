package com.example.covidmanagementapp.Ishika;

import java.io.Serializable;

public class MedicineUsage implements Serializable {

    private int patientId;
    private String patientName;
    private String medicineName;
    private String dosage;
    private String timesPerDay;
    private String takenTime;
    private String duration;
    private String reportDate;

    public MedicineUsage(int patientId, String patientName, String medicineName, String dosage, String timesPerDay, String takenTime, String duration, String reportDate) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.medicineName = medicineName;
        this.dosage = dosage;
        this.timesPerDay = timesPerDay;
        this.takenTime = takenTime;
        this.duration = duration;
        this.reportDate = reportDate;
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

    public String getTimesPerDay() {
        return timesPerDay;
    }

    public void setTimesPerDay(String timesPerDay) {
        this.timesPerDay = timesPerDay;
    }

    public String getTakenTime() {
        return takenTime;
    }

    public void setTakenTime(String takenTime) {
        this.takenTime = takenTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "MedicineUsage{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", dosage='" + dosage + '\'' +
                ", timesPerDay='" + timesPerDay + '\'' +
                ", takenTime='" + takenTime + '\'' +
                ", duration='" + duration + '\'' +
                ", reportDate='" + reportDate + '\'' +
                '}';
    }
}

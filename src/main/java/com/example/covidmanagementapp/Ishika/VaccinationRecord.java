package com.example.covidmanagementapp.Ishika;

import java.io.Serializable;

public class VaccinationRecord implements Serializable {

    private int patientId;
    private String patientName;
    private String doseNumber;
    private String vaccineName;
    private String batchNumber;
    private String center;
    private String date;
    private String notes;

    public VaccinationRecord(int patientId, String patientName, String doseNumber, String vaccineName, String batchNumber, String center, String date, String notes) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doseNumber = doseNumber;
        this.vaccineName = vaccineName;
        this.batchNumber = batchNumber;
        this.center = center;
        this.date = date;
        this.notes = notes;
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

    public String getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(String doseNumber) {
        this.doseNumber = doseNumber;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "VaccinationRecord{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", doseNumber='" + doseNumber + '\'' +
                ", vaccineName='" + vaccineName + '\'' +
                ", batchNumber='" + batchNumber + '\'' +
                ", center='" + center + '\'' +
                ", date='" + date + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}

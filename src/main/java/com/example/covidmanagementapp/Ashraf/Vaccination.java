package com.example.covidmanagementapp.Ashraf;

import java.io.Serializable;

public class Vaccination implements Serializable {

    private int patientId;
    private String doseNumber;
    private String vaccineType;
    private String center;
    private String date;

    public Vaccination(int patientId, String doseNumber, String vaccineType, String center, String date) {
        this.patientId = patientId;
        this.doseNumber = doseNumber;
        this.vaccineType = vaccineType;
        this.center = center;
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(String doseNumber) {
        this.doseNumber = doseNumber;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
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

    @Override
    public String toString() {
        return "Vaccination{" +
                "patientId=" + patientId +
                ", doseNumber='" + doseNumber + '\'' +
                ", vaccineType='" + vaccineType + '\'' +
                ", center='" + center + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

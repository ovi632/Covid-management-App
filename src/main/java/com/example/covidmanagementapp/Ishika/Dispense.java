package com.example.covidmanagementapp.Ishika;

import java.io.Serializable;

public class Dispense implements Serializable {

    private int patientId;
    private String medicineName;
    private int quantity;
    private String date;

    public Dispense(int patientId, String medicineName, int quantity, String date) {
        this.patientId = patientId;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Dispense{" +
                "patientId=" + patientId +
                ", medicineName='" + medicineName + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }
}

package com.example.covidmanagementapp.Ishika;

import java.io.Serializable;

public class MedicineStock implements Serializable {

    private String medicineName;
    private int quantity;
    private String date;

    public MedicineStock(String medicineName, int quantity, String date) {
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.date = date;
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
        return "MedicineStock{" +
                "medicineName='" + medicineName + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }
}
package com.example.covidmanagementapp.Ishika;

import java.time.LocalDate;

public class PharmacyStock {
    private String medicineName;
    private String medicineID;
    private int availableQuantity;
    private String stockStatus;
    private LocalDate expiryDate;

    public PharmacyStock(String medicineName, String medicineID, int availableQuantity, String stockStatus, LocalDate expiryDate) {
        this.medicineName = medicineName;
        this.medicineID = medicineID;
        this.availableQuantity = availableQuantity;
        this.stockStatus = stockStatus;
        this.expiryDate = expiryDate;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "PharmacyStock{" +
                "medicineName='" + medicineName + '\'' +
                ", medicineID='" + medicineID + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", stockStatus='" + stockStatus + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

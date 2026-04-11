package com.example.covidmanagementapp.Ishika;

public class PharmacyStaff {
    private String name;
    private String id;
    private String pharmacyLocation;

    public PharmacyStaff(String name, String id, String pharmacyLocation) {
        this.name = name;
        this.id = id;
        this.pharmacyLocation = pharmacyLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPharmacyLocation() {
        return pharmacyLocation;
    }

    public void setPharmacyLocation(String pharmacyLocation) {
        this.pharmacyLocation = pharmacyLocation;
    }

    @Override
    public String toString() {
        return "PharmacyStaff{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pharmacyLocation='" + pharmacyLocation + '\'' +
                '}';
    }
}

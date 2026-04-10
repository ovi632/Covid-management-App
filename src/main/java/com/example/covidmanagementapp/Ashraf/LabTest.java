package com.example.covidmanagementapp.Ashraf;


import java.io.Serializable;

public class LabTest implements Serializable {

    private String testType;
    private String slot;
    private String location;
    private String date;
    private int patientId;

    public LabTest(String testType, String slot, String location, String date, int patientId) {
        this.testType = testType;
        this.slot = slot;
        this.location = location;
        this.date = date;
        this.patientId = patientId;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "LabTest{" +
                "testType='" + testType + '\'' +
                ", slot='" + slot + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}

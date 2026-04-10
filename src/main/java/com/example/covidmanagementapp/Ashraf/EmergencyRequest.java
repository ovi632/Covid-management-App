package com.example.covidmanagementapp.Ashraf;

import java.io.Serializable;

public class EmergencyRequest implements Serializable {

    private int patientId;
    private String patientName;
    private String location;
    private String emergencyType;
    private String description;

    public EmergencyRequest(int patientId, String patientName, String location, String emergencyType, String description) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.location = location;
        this.emergencyType = emergencyType;
        this.description = description;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmergencyType() {
        return emergencyType;
    }

    public void setEmergencyType(String emergencyType) {
        this.emergencyType = emergencyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "EmergencyRequest{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", location='" + location + '\'' +
                ", emergencyType='" + emergencyType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

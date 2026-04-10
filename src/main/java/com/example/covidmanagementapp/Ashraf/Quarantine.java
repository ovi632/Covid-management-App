package com.example.covidmanagementapp.Ashraf;


import java.io.Serializable;

public class Quarantine implements Serializable {

    private int patientId;
    private String patientName;
    private String type;
    private String activity;
    private String instructions;
    private String startDate;
    private String endDate;
    private int doctorId;

    public Quarantine(int patientId, String patientName, String type, String activity, String instructions, String startDate, String endDate, int doctorId) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.type = type;
        this.activity = activity;
        this.instructions = instructions;
        this.startDate = startDate;
        this.endDate = endDate;
        this.doctorId = doctorId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public String toString() {
        return "Quarantine{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", type='" + type + '\'' +
                ", activity='" + activity + '\'' +
                ", instructions='" + instructions + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", doctorId=" + doctorId +
                '}';
    }
}

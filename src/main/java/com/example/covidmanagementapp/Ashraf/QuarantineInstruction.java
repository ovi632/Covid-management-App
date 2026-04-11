package com.example.covidmanagementapp.Ashraf;

import java.time.LocalDate;

public class QuarantineInstruction {
    private String patientName , quarantineType , instructionDetails , allowedActivities ;
    private int doctorId , registrationId ;
    private LocalDate startDate;
    private LocalDate endDate;

    public QuarantineInstruction(String patientName, String quarantineType, String instructionDetails, String allowedActivities, int doctorId, int registrationId, LocalDate startDate, LocalDate endDate) {
        this.patientName = patientName;
        this.quarantineType = quarantineType;
        this.instructionDetails = instructionDetails;
        this.allowedActivities = allowedActivities;
        this.doctorId = doctorId;
        this.registrationId = registrationId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getQuarantineType() {
        return quarantineType;
    }

    public void setQuarantineType(String quarantineType) {
        this.quarantineType = quarantineType;
    }

    public String getInstructionDetails() {
        return instructionDetails;
    }

    public void setInstructionDetails(String instructionDetails) {
        this.instructionDetails = instructionDetails;
    }

    public String getAllowedActivities() {
        return allowedActivities;
    }

    public void setAllowedActivities(String allowedActivities) {
        this.allowedActivities = allowedActivities;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "QuarantineInstruction{" +
                "patientName='" + patientName + '\'' +
                ", quarantineType='" + quarantineType + '\'' +
                ", instructionDetails='" + instructionDetails + '\'' +
                ", allowedActivities='" + allowedActivities + '\'' +
                ", doctorId=" + doctorId +
                ", registrationId=" + registrationId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

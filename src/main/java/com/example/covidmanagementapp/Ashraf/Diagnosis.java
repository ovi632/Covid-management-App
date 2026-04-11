package com.example.covidmanagementapp.Ashraf;

import java.time.LocalDate;

public class Diagnosis {
    private String patientName, doctorId, symptoms, diagnosisDetails, prescribedMedicine, dosage, severityLevel;
    private int registrationId;
    private LocalDate visitDate;

    public Diagnosis(String patientName, String doctorId, String symptoms, String diagnosisDetails, String prescribedMedicine, String dosage, String severityLevel, int registrationId, LocalDate visitDate) {
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.symptoms = symptoms;
        this.diagnosisDetails = diagnosisDetails;
        this.prescribedMedicine = prescribedMedicine;
        this.dosage = dosage;
        this.severityLevel = severityLevel;
        this.registrationId = registrationId;
        this.visitDate = visitDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosisDetails() {
        return diagnosisDetails;
    }

    public void setDiagnosisDetails(String diagnosisDetails) {
        this.diagnosisDetails = diagnosisDetails;
    }

    public String getPrescribedMedicine() {
        return prescribedMedicine;
    }

    public void setPrescribedMedicine(String prescribedMedicine) {
        this.prescribedMedicine = prescribedMedicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "patientName='" + patientName + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", diagnosisDetails='" + diagnosisDetails + '\'' +
                ", prescribedMedicine='" + prescribedMedicine + '\'' +
                ", dosage='" + dosage + '\'' +
                ", severityLevel='" + severityLevel + '\'' +
                ", registrationId=" + registrationId +
                ", visitDate=" + visitDate +
                '}';
    }
}
package com.example.covidmanagementapp.Ashraf;

import java.io.Serializable;

public class Diagnosis implements Serializable {
private int patientId;
    private String patientName;
    private int doctorId;
    private String symptoms;
    private String diagnosisDetails;
    private String severity;
    private String dosage;
    private String date;

    public Diagnosis(int patientId, String patientName, int doctorId, String symptoms, String diagnosisDetails, String severity, String dosage, String date) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorId = doctorId;
        this.symptoms = symptoms;
        this.diagnosisDetails = diagnosisDetails;
        this.severity = severity;
        this.dosage = dosage;
        this.date = date;
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

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
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

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", doctorId=" + doctorId +
                ", symptoms='" + symptoms + '\'' +
                ", diagnosisDetails='" + diagnosisDetails + '\'' +
                ", severity='" + severity + '\'' +
                ", dosage='" + dosage + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

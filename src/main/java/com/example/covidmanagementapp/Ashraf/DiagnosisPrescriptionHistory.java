package com.example.covidmanagementapp.Ashraf;

import java.time.LocalDate;

public class DiagnosisPrescriptionHistory {
    private String symptomsSummary , diagnosisSummary , prescribedMedicine , dosage ;
    private int duration , doctorId;
    private LocalDate date;

    public DiagnosisPrescriptionHistory(String symptomsSummary, String diagnosisSummary, String prescribedMedicine, String dosage, int duration, int doctorId, LocalDate date) {
        this.symptomsSummary = symptomsSummary;
        this.diagnosisSummary = diagnosisSummary;
        this.prescribedMedicine = prescribedMedicine;
        this.dosage = dosage;
        this.duration = duration;
        this.doctorId = doctorId;
        this.date = date;
    }

    public String getSymptomsSummary() {
        return symptomsSummary;
    }

    public void setSymptomsSummary(String symptomsSummary) {
        this.symptomsSummary = symptomsSummary;
    }

    public String getDiagnosisSummary() {
        return diagnosisSummary;
    }

    public void setDiagnosisSummary(String diagnosisSummary) {
        this.diagnosisSummary = diagnosisSummary;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DiagnosisPrescriptionHistory{" +
                "symptomsSummary='" + symptomsSummary + '\'' +
                ", diagnosisSummary='" + diagnosisSummary + '\'' +
                ", prescribedMedicine='" + prescribedMedicine + '\'' +
                ", dosage='" + dosage + '\'' +
                ", duration=" + duration +
                ", doctorId=" + doctorId +
                ", date=" + date +
                '}';
    }
}

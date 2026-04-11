package com.example.covidmanagementapp.Ishika;

import java.io.Serializable;

public class PatientDischarge implements Serializable {

    private int patientId;
    private String ward;
    private String status;
    private String remarks;
    private String date;

    public PatientDischarge(int patientId, String ward, String status, String remarks, String date) {
        this.patientId = patientId;
        this.ward = ward;
        this.status = status;
        this.remarks = remarks;
        this.date = date;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PatientDischarge{" +
                "patientId=" + patientId +
                ", ward='" + ward + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

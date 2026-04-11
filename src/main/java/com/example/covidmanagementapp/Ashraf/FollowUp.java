package com.example.covidmanagementapp.Ashraf;

public class FollowUp {
    private String patientName , notes , status ;
    private int doctorId , registrationId ;

    public FollowUp(String patientName, String notes, String status, int doctorId, int registrationId) {
        this.patientName = patientName;
        this.notes = notes;
        this.status = status;
        this.doctorId = doctorId;
        this.registrationId = registrationId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "FollowUp{" +
                "patientName='" + patientName + '\'' +
                ", notes='" + notes + '\'' +
                ", status='" + status + '\'' +
                ", doctorId=" + doctorId +
                ", registrationId=" + registrationId +
                '}';
    }
}

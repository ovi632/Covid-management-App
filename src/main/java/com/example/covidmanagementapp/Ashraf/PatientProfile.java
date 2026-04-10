package com.example.covidmanagementapp.Ashraf;

import java.time.LocalDate;

public class PatientProfile {
    private String name , patientId , gender , phoneNumber , address , covidStatus;
    private int age;
    private LocalDate lastUpdate;

    public PatientProfile(String name, String patientId, String gender, String phoneNumber, String address, String covidStatus, int age, LocalDate lastUpdate) {
        this.name = name;
        this.patientId = patientId;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.covidStatus = covidStatus;
        this.age = age;
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "PatientProfile{" +
                "name='" + name + '\'' +
                ", patientId='" + patientId + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", covidStatus='" + covidStatus + '\'' +
                ", age=" + age +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

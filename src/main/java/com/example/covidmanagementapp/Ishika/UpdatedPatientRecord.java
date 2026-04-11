package com.example.covidmanagementapp.Ishika;

import java.io.Serializable;

public class UpdatedPatientRecord implements Serializable {

    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String address;
    private String covidStatus;

    public UpdatedPatientRecord(int patientId, String name, int age, String gender, String address, String covidStatus) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.covidStatus = covidStatus;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "UpdatedPatientRecord{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", covidStatus='" + covidStatus + '\'' +
                '}';
    }
}

package com.example.covidmanagementapp.Ashraf;

public class MyHealthProfile {
    private String name;
    private int age;
    private String gender;
    private String diagnosis;
    private String covidStatus;
    private String lastUpdate;

    public MyHealthProfile(String name, int age, String gender, String diagnosis, String covidStatus, String lastUpdate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
        this.covidStatus = covidStatus;
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "MyHealthProfile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", covidStatus='" + covidStatus + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                '}';
    }
}

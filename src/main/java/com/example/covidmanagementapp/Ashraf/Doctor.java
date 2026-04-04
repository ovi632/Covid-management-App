package com.example.covidmanagementapp.Ashraf;

public class Doctor {
    private String name ;
    private String id ;
    private String specialization;

    public Doctor(String name, String id, String specialization) {
        this.name = name;
        this.id = id;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}

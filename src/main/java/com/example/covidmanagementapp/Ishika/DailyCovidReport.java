package com.example.covidmanagementapp.Ishika;


import java.io.Serializable;

public class DailyCovidReport implements Serializable {

    private int childAffected;
    private int teenAffected;
    private int middleAgeAffected;
    private int newAffected;
    private int newRecovered;

    public DailyCovidReport(int childAffected, int teenAffected, int middleAgeAffected, int newAffected, int newRecovered) {
        this.childAffected = childAffected;
        this.teenAffected = teenAffected;
        this.middleAgeAffected = middleAgeAffected;
        this.newAffected = newAffected;
        this.newRecovered = newRecovered;
    }

    public int getChildAffected() {
        return childAffected;
    }

    public void setChildAffected(int childAffected) {
        this.childAffected = childAffected;
    }

    public int getTeenAffected() {
        return teenAffected;
    }

    public void setTeenAffected(int teenAffected) {
        this.teenAffected = teenAffected;
    }

    public int getMiddleAgeAffected() {
        return middleAgeAffected;
    }

    public void setMiddleAgeAffected(int middleAgeAffected) {
        this.middleAgeAffected = middleAgeAffected;
    }

    public int getNewAffected() {
        return newAffected;
    }

    public void setNewAffected(int newAffected) {
        this.newAffected = newAffected;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        this.newRecovered = newRecovered;
    }

    @Override
    public String toString() {
        return "DailyCovidReport{" +
                "childAffected=" + childAffected +
                ", teenAffected=" + teenAffected +
                ", middleAgeAffected=" + middleAgeAffected +
                ", newAffected=" + newAffected +
                ", newRecovered=" + newRecovered +
                '}';
    }
}

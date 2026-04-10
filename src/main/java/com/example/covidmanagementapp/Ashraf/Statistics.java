package com.example.covidmanagementapp.Ashraf;

import java.time.LocalDate;

public class Statistics {
    private LocalDate fromDate , toDate;
    private int activeCases , recoveredCases , criticalCases , deceasedCases ;

    public Statistics(LocalDate fromDate, LocalDate toDate, int activeCases, int recoveredCases, int criticalCases, int deceasedCases) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.activeCases = activeCases;
        this.recoveredCases = recoveredCases;
        this.criticalCases = criticalCases;
        this.deceasedCases = deceasedCases;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(int activeCases) {
        this.activeCases = activeCases;
    }

    public int getRecoveredCases() {
        return recoveredCases;
    }

    public void setRecoveredCases(int recoveredCases) {
        this.recoveredCases = recoveredCases;
    }

    public int getCriticalCases() {
        return criticalCases;
    }

    public void setCriticalCases(int criticalCases) {
        this.criticalCases = criticalCases;
    }

    public int getDeceasedCases() {
        return deceasedCases;
    }

    public void setDeceasedCases(int deceasedCases) {
        this.deceasedCases = deceasedCases;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", activeCases=" + activeCases +
                ", recoveredCases=" + recoveredCases +
                ", criticalCases=" + criticalCases +
                ", deceasedCases=" + deceasedCases +
                '}';
    }
}

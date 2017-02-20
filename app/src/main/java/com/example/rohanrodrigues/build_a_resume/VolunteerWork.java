package com.example.rohanrodrigues.build_a_resume;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class VolunteerWork {
    private String nameOfWork;
    private int startDate, endDate;
    private int totalHours;

    public VolunteerWork(String nameOfWork, int startDate, int endDate, int totalHours) {
        this.nameOfWork = nameOfWork;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalHours = totalHours;
    }

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setNameOfWork(String nameOfWork) {
        this.nameOfWork = nameOfWork;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(int totalHours) {
        this.totalHours = totalHours;
    }

}

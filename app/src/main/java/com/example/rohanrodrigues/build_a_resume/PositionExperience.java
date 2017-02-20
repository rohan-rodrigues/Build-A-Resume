package com.example.rohanrodrigues.build_a_resume;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class PositionExperience {
    private String positionTitle;
    private String startDate, endDate;
    private String companyName;

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public PositionExperience(String positionTitle, String startDate, String endDate, String companyName) {
        this.positionTitle = positionTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyName = companyName;
    }
}

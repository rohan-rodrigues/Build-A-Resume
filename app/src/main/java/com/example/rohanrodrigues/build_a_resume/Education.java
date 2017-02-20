package com.example.rohanrodrigues.build_a_resume;

import java.util.ArrayList;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class Education {
    private String schoolName;
    private int startDate, endDate;
    private ArrayList<String> accomplishments;

    public Education(String schoolName, int startDate, int endDate, ArrayList<String> accomplishments) {
        this.schoolName = schoolName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.accomplishments = accomplishments;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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

    public ArrayList<String> getAccomplishments() {
        return accomplishments;
    }

    public void addAccomplishments(String s) {
        accomplishments.add(s);
    }

    public void removeAccomplishment(String s) {
        for (int i = 0; i < accomplishments.size(); i++) {
            if (accomplishments.get(i).equals(s)) {
                accomplishments.remove(i);
            }
        }
    }
}

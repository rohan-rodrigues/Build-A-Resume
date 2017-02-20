package com.example.rohanrodrigues.build_a_resume;

/**
 * Created by rohanrodrigues on 2/19/17.
 */

public class TestScore {
    private String testName;
    private String testDate;
    private int testScore;

    public TestScore (String testName, String testDate, int testScore) {
        this.testName = testName;
        this.testDate = testDate;
        this.testScore = testScore;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }
}

package com.example.kevin.ibmchallenge.Models;

/**
 * Created by Kevin on 12/6/2017.
 */

public class Flight {
    private String depDay;
    private String depDayNum;
    private String depMonth;
    private String depToDest;

    public Flight(String newDepDay, String newDepDayNum, String newDepMonth, String newDepToDest) {
        depDay = newDepDay;
        depDayNum = newDepDayNum;
        depMonth = newDepMonth;
        depToDest = newDepToDest;
    }

    public String getDepDay() {
        return depDay;
    }

    public void setDepDay(String depDay) {
        this.depDay = depDay;
    }

    public String getDepDayNum() {
        return depDayNum;
    }

    public void setDepDayNum(String depDayNum) {
        this.depDayNum = depDayNum;
    }

    public String getDepMonth() {
        return depMonth;
    }

    public void setDepMonth(String depMonth) {
        this.depMonth = depMonth;
    }

    public String getDepToDest() {
        return depToDest;
    }

    public void setDepToDest(String depToDest) {
        this.depToDest = depToDest;
    }
}

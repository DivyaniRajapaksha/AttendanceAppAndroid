package com.example.instituteregistration.Demo;

public class Class {

    private String classID;
    private String className;
    private String startTime;
    private String endTime;
    private String subject;
    private String date;
    private String grade;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Class(String classID, String className, String startTime, String endTime, String subject, String date, String grade) {
        this.classID = classID;
        this.className = className;
        this.startTime = startTime;
        this.endTime = endTime;
        this.subject = subject;
        this.date = date;
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Class(){
        //class cons
    }


    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID1) {
        this.classID = classID1;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className1) {
        this.className = className1;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime1) {
        this.startTime = startTime1;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime1) {
        this.endTime = endTime1;
    }


}


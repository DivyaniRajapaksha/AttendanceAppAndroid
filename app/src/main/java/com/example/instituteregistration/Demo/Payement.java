package com.example.instituteregistration.Demo;

public class Payement {

    private String classCode;
    private String stdMail;
    private String month;

    public Payement(){

    }

    public Payement(String classCode, String stdMail, String month) {
        this.classCode = classCode;
        this.stdMail = stdMail;
        this.month = month;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getStdMail() {
        return stdMail;
    }

    public void setStdMail(String stdMail) {
        this.stdMail = stdMail;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}

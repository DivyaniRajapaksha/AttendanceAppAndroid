package com.example.instituteregistration.Demo;

public class Teacher {

    private String fullName;
    private String subject;
    private String email;
    private String password;
    private String address;
    private String mobileNo;

    public Teacher(){}


    public Teacher(String fullName, String subject, String email, String password, String address, String mobileNo) {
        this.fullName = fullName;
        this.subject = subject;
        this.email = email;
        this.password = password;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    public Teacher(String fullName, String subject, String email, String address, String mobileNo) {
        this.fullName = fullName;
        this.subject = subject;
        this.email = email;
        this.address = address;
        this.mobileNo = mobileNo;
    }

    public Teacher(String email, String password) {

        this.email = email;

        this.password = password;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
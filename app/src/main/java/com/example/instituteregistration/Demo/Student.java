package com.example.instituteregistration.Demo;

public class Student {
    private String fName;
    private String lName;
    private String email;
    private String address;
    private String password;


    public Student(String fName, String lName, String email, String address, String password) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public Student(String fName, String lName, String email, String address) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.address = address;
    }

    public Student(){

    }
    public Student(String email, String password) {

        this.email = email;

        this.password = password;

    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

package com.example.instituteregistration;

public class ListItemClass {


    private String ClassName;
    private String Subject;
    private String STime;
    private String TTime;
    private String Email;
    private String Tel;
    private String Teacher;

    public ListItemClass(){}

    public ListItemClass(String className, String subject, String STime, String TTime, String email, String tel, String teacher) {
        ClassName = className;
        Subject = subject;
        this.STime = STime;
        this.TTime = TTime;
        Email = email;
        Tel = tel;
        Teacher = teacher;
    }


    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getSTime() {
        return STime;
    }

    public void setSTime(String STime) {
        this.STime = STime;
    }

    public String getTTime() {
        return TTime;
    }

    public void setTTime(String TTime) {
        this.TTime = TTime;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }
}

package com.example.instituteregistration.Demo;

public class Institute {

    private String name;
    private String manager;
    private String password;
    private String address;
    private String website;
    private String email;
    private String hotline;
    private String description;


    public Institute(){

    }

    public Institute(String name, String manager, String password, String address, String website, String email, String hotline, String description) {
        this.name = name;
        this.manager = manager;
        this.password = password;
        this.address = address;
        this.website = website;
        this.email = email;
        this.hotline = hotline;
        this.description = description;
    }


    public Institute(String email, String password) {

        this.email = email;

        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

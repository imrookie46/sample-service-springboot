package com.nu.sample.model;


/**
 * this class will be used to response with fields:
 * userName, location, status
 * */
public class SampleResModel {


    private String userName;
    private String location;
    private String status;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

/**
* Author: ImRookie46
* 2019
*/
package com.nu.sample.model;

import javax.validation.constraints.NotNull;

/**
 * this class will be used to map req with fields:
 * userName, location, status
 * */
public class SampleReqModel {

    @NotNull(message="userName can not be Null")
    private String userName;
    @NotNull(message="location can not be Null")
    private String location;
    @NotNull(message="status can not be Null")
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

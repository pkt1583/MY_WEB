package com.project.domain;

import javax.persistence.*;

/**
 * Created by pankaj on 5/10/16.
 */
@Embeddable
public class Address {
    @Basic
    private String state;

    @Basic
    private String city;

    @Basic
    private String pincode;

    @Basic
    private String streetName;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}

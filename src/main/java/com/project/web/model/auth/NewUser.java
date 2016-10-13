package com.project.web.model.auth;

import com.project.service.UserService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.LinkedHashMap;
import java.util.Map;

@Model
@RequestScoped
public class NewUser {
    private String username;
    @Inject
    private UserService userService;

    private String password;

    private Map stateCity = new LinkedHashMap();
    private String streetName;

    public Map getStateCity() {
        return stateCity;
    }

    public void setStateCity(Map stateCity) {
        this.stateCity = stateCity;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package com.test.web.model.auth;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;

/**
 * Created  on 7/29/2015.
 */
@RequestScoped
@Model
public class Credentials {
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

package com.test.service;


import com.test.dao.UserDao;
import com.test.domain.Userdetails;
import com.test.web.model.auth.Credentials;

import javax.ejb.EJB;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by pankaj on 01-02-2015.
 */
@Named(value = "authenticationService")

public class AuthenticationService implements Serializable {

    @EJB
    private UserDao<Userdetails> userDao;

    public boolean authenticate(Credentials credentials) {
        Userdetails userdetails = userDao.findByUserId(credentials.getUsername());
        if (userdetails != null) {
            return userdetails.getUserPassword().equals(credentials.getPassword());
        }
        return false;
    }
}

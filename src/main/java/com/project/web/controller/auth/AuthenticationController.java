package com.project.web.controller.auth;

import com.project.annotation.LoggedInUser;
import com.project.domain.Userdetails;
import com.project.service.UserService;
import com.project.web.model.auth.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 */
@ApplicationScoped
public class AuthenticationController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());


    @Inject
    UserService userService;

    @Inject
    UserInfo userInfo;

    private Userdetails user;


    public String authenticate() {
        logger.debug("Got request to Authenticate " + userInfo);
        Userdetails userdetails = userService.authenticate();
        if (userdetails != null) {
            this.user = userdetails;
            return "success";
        } else {
            return "index";
        }

    }

    @Produces
    @SessionScoped
    @LoggedInUser

    public Userdetails getLoggedUser() {
        return this.user;
    }

}

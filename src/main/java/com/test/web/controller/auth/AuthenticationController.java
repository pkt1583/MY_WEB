package com.test.web.controller.auth;

import com.test.annotation.LoggedInUser;
import com.test.service.UserService;
import com.test.web.model.auth.Credentials;
import com.test.web.model.auth.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 */
@Named("authenticationController")
@RequestScoped
public class AuthenticationController {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    Credentials credentials;

    @Inject
    UserService userService;

    private UserInfo userInfo;

    public String authenticate() {
        logger.debug("Got request to Authenticate " + userInfo);
        if (userService.authenticate(credentials)) {
            userInfo = new UserInfo();
            userInfo.setUserId(credentials.getUsername());
            userInfo.setPassword(credentials.getPassword());
            return "success";
        } else {
            return "index";
        }

    }

    @Produces
    @LoggedInUser
    public UserInfo getUserInfo() {
        logger.debug("Setting userinfo via Factory");
        if (userInfo != null) {
            return userInfo;
        } else {
            throw new RuntimeException("User not found");
        }
    }
}

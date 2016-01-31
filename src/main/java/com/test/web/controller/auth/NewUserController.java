package com.test.web.controller.auth;

import com.test.service.UserService;
import com.test.web.model.auth.NewUser;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("newUserController")
@ApplicationScoped
public class NewUserController {

    @Inject
    private UserService userService;

    public void createNewUser(NewUser newuser) {
        System.out.println("Called new user created " + newuser);
        userService.createNewUse(newuser);
    }
}

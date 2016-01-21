package com.test.web.controller.auth;

import com.test.service.UserService;
import com.test.web.model.auth.NewUser;
import com.test.web.model.auth.UserInfo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("newUserController")
@ApplicationScoped
public class NewUserController {

    @Inject
    private UserService userService;

    public void createNewUser(NewUser newuser){
       userService.createNewUse(newuser);
    }
}

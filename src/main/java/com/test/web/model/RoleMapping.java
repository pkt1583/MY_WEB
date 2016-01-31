/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.web.model;

import com.test.annotation.LoggedInUser;
import com.test.domain.ApplicationLinks;
import com.test.domain.UserRoles;
import com.test.domain.Userdetails;
import com.test.service.ApplicationService;
import com.test.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "roleMapping")
@SessionScoped
public class RoleMapping implements Serializable{

    private List<ApplicationLinks> target = new ArrayList<>();
    private List<ApplicationLinks> source = new ArrayList<>();
    @Inject
    private UserService userService;

    @Inject
    private ApplicationService applicationService;

    @Inject
    @LoggedInUser
    private Userdetails userDetails;
    private UserRoles selectedRole;
    private List<UserRoles> userRoles;

    public List<ApplicationLinks> getSource() {
        return source;
    }

    public void setSource(List<ApplicationLinks> source) {
        this.source = source;
    }

    public List<ApplicationLinks> getTarget() {
        return target;
    }

    public void setTarget(List<ApplicationLinks> target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "RoleMapping{" +
                "target=" + target +
                ", source=" + source +
                ", userService=" + userService +
                ", applicationService=" + applicationService +
                ", userDetails=" + userDetails +
                ", selectedRole=" + selectedRole +
                ", userRoles=" + userRoles +
                '}';
    }

    public UserRoles getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(UserRoles selectedRole) {
        this.selectedRole = selectedRole;
    }

    @PostConstruct
    public void init() {
        System.out.println(" Init Called ");
        this.selectedRole=userDetails.getUserRoles().get(0);
        List<UserRoles> userRolesList = userService.getAllRoles();
        this.userRoles = userRolesList;
        List<ApplicationLinks> applicationLinkses = applicationService.getAllApplicationLinks();
        for (UserRoles userRoles : userRolesList) {
            target.addAll(userRoles.getApplicationLinks());
        }
        source.addAll(applicationLinkses);

    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public Userdetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(Userdetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }


}

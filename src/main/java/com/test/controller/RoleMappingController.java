/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.domain.ApplicationLinks;
import com.test.domain.UserRoles;
import com.test.service.ApplicationService;
import com.test.web.model.RoleMapping;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "roleMappingController")
@ApplicationScoped
public class RoleMappingController {

    @Inject
    private RoleMapping roleMapping;

    @Inject
    private ApplicationService applicationService;

    public String mapApplicationsToRoles() {
        System.out.println("RoleMapping " + roleMapping);
        return "roleMapping";
    }

    public void roleChanged(ValueChangeEvent e) {
        UserRoles userRoles = (UserRoles) e.getNewValue();
        System.out.println("Application Links are " + userRoles.getApplicationLinks());
        List<ApplicationLinks> applicationLinkses = applicationService.getAllApplicationLinks();
        roleMapping.setSelectedRole(userRoles);
        roleMapping.getSource().clear();
        roleMapping.getSource().addAll(applicationLinkses);
        roleMapping.getTarget().clear();
        roleMapping.getTarget().addAll(userRoles.getApplicationLinks());
        //roleMapping.setTarget(new ArrayList<ApplicationLinks>(userRoles.getApplicationLinks()));
    }
}

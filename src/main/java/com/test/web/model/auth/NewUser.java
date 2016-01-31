package com.test.web.model.auth;

import com.test.domain.UserRoles;
import com.test.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
@RequestScoped
public class NewUser {
    private String username;

    private List<UserRoles> userRoles;

    @Inject
    private UserService userService;

    private UserRoles selectedRole;
    private String password;
    private String confirmPassword;

    @Override
    public String toString() {
        return "NewUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    @PostConstruct
    public void populateRoles() {
        List<UserRoles> userRoles = userService.getAllRoles();
        setUserRoles(userRoles);
        System.out.println("Calling populate Roles " + userRoles);
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    public UserRoles getSelectedRole() {
        return selectedRole;
    }

    public void setSelectedRole(UserRoles selectedRole) {
        this.selectedRole = selectedRole;
    }
}

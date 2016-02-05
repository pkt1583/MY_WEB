package com.test.service;

import com.test.dao.UserDao;
import com.test.domain.ApplicationLinks;
import com.test.domain.UserRoles;
import com.test.domain.Userdetails;
import com.test.service.exception.UserAlreadyExistsException;
import com.test.web.model.auth.NewUser;
import com.test.web.model.auth.UserInfo;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

@Named(value = "userSerivce")
@ApplicationScoped
public class UserService implements Serializable{

    @EJB(beanName = "userDao")
    private UserDao userDao;

    @Inject
    private UserInfo credential;

    public boolean createNewUse(NewUser userInfo) {
        Userdetails userdetails = userDao.getUserDetailsByUserName(userInfo.getUsername());
        if (userdetails != null) {
            throw new UserAlreadyExistsException("The user " + userInfo.getUsername() + "is already present in system");
        } else {
            userdetails = new Userdetails();
            userdetails.setUserId(userInfo.getUsername());
            userdetails.setUserPassword(userInfo.getPassword());
            userdetails.getUserRoles().add(userInfo.getSelectedRole());
            userDao.save(userdetails);
            return true;
        }
    }

    public List<UserRoles> getAllRoles() {
        return userDao.getAllElements(UserRoles.class);
    }


    public Userdetails authenticate() {
        Userdetails userdetails = userDao.getUserDetailsByUserName(credential.getUserId());
        if (userdetails != null) {
            if(userdetails.getUserPassword().equals(credential.getPassword())){
                return userdetails;
            }
        }
        return null;
    }

    public UserRoles getRoleById(String s) {
        return userDao.findOneById(Integer.parseInt(s), UserRoles.class);
    }

    public void saveRoleMapping(UserRoles selectedRole, List<ApplicationLinks> target) {
        selectedRole.getApplicationLinks().clear();
        selectedRole.getApplicationLinks().addAll(target);
        userDao.update(selectedRole);
    }
}

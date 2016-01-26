package com.test.service;

import com.test.dao.UserDao;
import com.test.domain.UserRoles;
import com.test.domain.Userdetails;
import com.test.service.exception.UserAlreadyExistsException;
import com.test.web.model.auth.Credentials;
import com.test.web.model.auth.NewUser;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named(value = "userSerivce")
@ApplicationScoped
public class UserService {

    @EJB(beanName = "userDao")
    private UserDao userDao;

    public boolean createNewUse(NewUser userInfo) {
        Userdetails userdetails = userDao.findByUserId(userInfo.getUsername(), Userdetails.class);
        if (userdetails != null) {
            throw new UserAlreadyExistsException("The user " + userInfo.getUsername() + "is already present in system");
        } else {
            userdetails = new Userdetails();
            userdetails.setUserId(userInfo.getUsername());
            userdetails.setUserPassword(userInfo.getPassword());
            List<UserRoles> roles=userdetails.getUserRoles();
            if(roles==null){
                roles=new ArrayList<>();
                roles.add(userInfo.getSelectedRole());
                userdetails.setUserRoles(roles);
            }else {
                userdetails.getUserRoles().add(userInfo.getSelectedRole());
            }
            userDao.save(userdetails);
            return true;
        }
    }

    public List<UserRoles> getAllRoles() {
        return userDao.getAllElements(UserRoles.class);
    }

    public boolean authenticate(Credentials credentials) {
        Userdetails userdetails = userDao.findByUserId(credentials.getUsername(), Userdetails.class);
        if (userdetails != null) {
            return userdetails.getUserPassword().equals(credentials.getPassword());
        }
        return false;
    }
}

package com.project.service;

import com.project.dao.UserDao;
import com.project.domain.Userdetails;
import com.project.service.exception.UserAlreadyExistsException;
import com.project.web.model.auth.NewUser;
import com.project.web.model.auth.UserInfo;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

//@Named(value = "userSerivce")
@ApplicationScoped
public class UserService implements Serializable {

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
            userDao.save(userdetails);
            return true;
        }
    }



    public Userdetails authenticate() {
        Userdetails userdetails = userDao.getUserDetailsByUserName(credential.getUserId());
        if (userdetails != null) {
            if (userdetails.getUserPassword().equals(credential.getPassword())) {
                return userdetails;
            }
        }
        return null;
    }

}

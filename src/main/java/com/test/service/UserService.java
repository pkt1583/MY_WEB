package com.test.service;

import com.test.dao.UserDao;
import com.test.domain.Userdetails;
import com.test.service.exception.UserAlreadyExistsException;
import com.test.web.model.auth.NewUser;
import com.test.web.model.auth.UserInfo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "userSerivce")
@ApplicationScoped
public class UserService {
    @Inject
    private UserDao<Userdetails> userDao;

    public boolean createNewUse(NewUser userInfo){
        Userdetails userdetails=  userDao.findByUserId(userInfo.getUsername());
        if(userdetails!=null){
            throw new UserAlreadyExistsException("The user "+userInfo.getUsername()+ "is already present in system");
        }else {
            userdetails=new Userdetails();
            userdetails.setUserId(userInfo.getUsername());
            userdetails.setUserPassword(userInfo.getPassword());
            userDao.save(userdetails);
            return true;
        }
    }
}

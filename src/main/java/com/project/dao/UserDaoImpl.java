package com.project.dao;

import com.project.domain.Userdetails;

import javax.ejb.Stateless;

//@Stateless(name = "userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

    @Override
    public Userdetails getUserDetailsByUserName(String userName) {
        return (Userdetails) entityManager.createNamedQuery("userDetails.findByUserName").setParameter("userName", userName).getSingleResult();
    }

    @Override
    public Userdetails getUserById(Integer id) {
        return super.findOneById(id, Userdetails.class);
    }

}

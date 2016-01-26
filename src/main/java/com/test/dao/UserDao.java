package com.test.dao;

import com.test.domain.Userdetails;

import java.util.List;

public interface UserDao {
    <T> T findByUserId(String userid,Class<T> domainClass);

    <T> void save(T userdetails);

   <T> List<T> getAllElements(Class<T> ofWhat);

}

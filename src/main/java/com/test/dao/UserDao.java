package com.test.dao;

import com.test.domain.Userdetails;

public interface UserDao<T> {
    T findByUserId(String userid);

    void save(T userdetails);
}

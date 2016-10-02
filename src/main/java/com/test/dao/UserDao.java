package com.test.dao;

import com.test.domain.Userdetails;

public interface UserDao extends BaseDao {
    Userdetails getUserDetailsByUserName(String userName);

    Userdetails getUserById(Integer id);

}

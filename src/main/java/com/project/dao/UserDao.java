package com.project.dao;

import com.project.domain.Userdetails;

public interface UserDao extends BaseDao {
    Userdetails getUserDetailsByUserName(String userName);

    Userdetails getUserById(Integer id);

}

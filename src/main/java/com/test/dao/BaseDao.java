package com.test.dao;

import com.test.domain.UserRoles;

import java.util.List;

public interface BaseDao {
    <T> T findOneById(Object id, Class<T> domainClass);

    <T> T findOneByExample(T domainClass, Class<T> domainClaz);

    <T> void save(T userdetails);

    <T> List<T> getAllElements(Class<T> ofWhat);

    <T> T update(T whichRole);
}

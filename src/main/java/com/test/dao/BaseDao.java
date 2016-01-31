package com.test.dao;

import java.util.List;

public interface BaseDao {
    <T> T findOneById(Object id, Class<T> domainClass);

    <T> T findOneByExample(T domainClass, Class<T> domainClaz);

    <T> void save(T userdetails);

    <T> List<T> getAllElements(Class<T> ofWhat);

}

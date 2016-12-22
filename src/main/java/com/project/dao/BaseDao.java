package com.project.dao;

import java.util.List;

public interface BaseDao {
    <T> T findOneById(Object id, Class<T> domainClass);

    <T> T findOneByExample(T domainClass, Class<T> domainClaz);

    <T> T save(T userdetails);

    <T> List<T> getAllElements(Class<T> ofWhat);

    <T> T update(T whichRole);
}

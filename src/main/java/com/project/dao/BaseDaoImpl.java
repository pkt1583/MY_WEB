package com.project.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BaseDaoImpl implements BaseDao  {

    protected final Logger logger = LoggerFactory.getLogger(getClass());


    @PersistenceContext
    protected EntityManager entityManager;


    @Override
    public <T> T findOneById(Object userid, Class<T> domainClass) {
        T userdetails = null;
        try {
            T testObj = entityManager.find(domainClass, userid);
            userdetails = testObj;
        } catch (NoResultException nre) {
            logger.error("User [ " + userid + " ] not found in database");
        }
        return userdetails;
    }


    @Override
    public <T> T findOneByExample(T domainClass, Class<T> domainClaz) {
        Example example = Example.create(domainClass);
        Session session = (Session) entityManager.getDelegate();
        return (T) session.createCriteria(domainClaz).add(example).uniqueResult();
    }


    @Override
    public <T> void save(T userdetails) {
         entityManager.persist(userdetails);
    }

    public <T> T merge(T whichObject) {
        return entityManager.merge(whichObject);
    }

    @Override
    public <T> List<T> getAllElements(Class<T> ofWhat) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(ofWhat);
        Root<T> userRolesRoot = criteriaQuery.from(ofWhat);
        criteriaQuery.select(userRolesRoot);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public <T> T update(T whichObject) {
        return merge(whichObject);

    }
}

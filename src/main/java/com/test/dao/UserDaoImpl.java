package com.test.dao;

import com.test.domain.UserRoles;
import com.test.domain.Userdetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless(name = "userDao")
public class UserDaoImpl implements UserDao {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @PersistenceContext(unitName = "mysqllocal")
    private EntityManager entityManager;

    @Override
    public <T> T findByUserId(String userid,Class<T> domainClass) {
        T userdetails = null;
        try {
            T testObj = entityManager.createNamedQuery("userDetails.findByUserId", domainClass)
                    .setParameter("userid", userid).getSingleResult();

            userdetails=testObj;
        } catch (NoResultException nre) {
            logger.error("User [ " + userid + " ] not found in database");
        }
        //entityManager.close();
        return userdetails;

    }


    @Override
    public <T> void save(T userdetails) {
        entityManager.persist(userdetails);
    }

    @Override
    public <T> List<T> getAllElements(Class<T> ofWhat) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(ofWhat);
        Root<T> userRolesRoot = criteriaQuery.from(ofWhat);
        criteriaQuery.select(userRolesRoot);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}

package com.test.dao;

import com.test.domain.Userdetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
@Local
public class UserDaoImpl implements UserDao<Userdetails> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @PersistenceContext(unitName = "mysqllocal")
    private EntityManager entityManager;

    @Override
    public Userdetails findByUserId(String userid) {
        Userdetails userdetails = new Userdetails();
        try {
            Object testObj = entityManager.createNamedQuery("userDetails.findByUserId", Userdetails.class)
                    .setParameter("userid", userid).getSingleResult();
            userdetails = (Userdetails) testObj;

        } catch (NoResultException nre) {
            logger.error("User [ " + userid + " ] not found in database");
        }
        if (userdetails == null) {
            userdetails = new Userdetails();
        }
        //entityManager.close();
        return userdetails;

    }

    @Override
    public void save(Userdetails userdetails) {
        entityManager.persist(userdetails);

    }
}

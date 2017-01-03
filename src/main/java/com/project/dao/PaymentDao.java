package com.project.dao;

import com.project.domain.Payment;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@EJB
public class PaymentDao {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean updatePaymant(Payment payment){
        entityManager.persist(payment);
        return true;
    }
}

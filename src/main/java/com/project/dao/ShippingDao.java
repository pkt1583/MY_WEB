package com.project.dao;

import com.project.domain.ProductOrder;
import com.project.domain.ShippingDetails;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ShippingDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveShippingDetails(ShippingDetails shippingDetails) {
        entityManager.persist(shippingDetails);
    }

    public void updateShippingInfo(ProductOrder productOrder) {
        entityManager.persist(productOrder);
    }
}

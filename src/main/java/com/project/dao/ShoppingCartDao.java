package com.project.dao;

import com.project.domain.ShoppingCart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ShoppingCartDao {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean updateCart(ShoppingCart cart) {
        entityManager.persist(cart);
        return true;
    }
}

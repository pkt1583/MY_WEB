package com.project.dao;

import com.project.domain.Inventory;
import com.project.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class InventoryDao {
    @PersistenceContext
    private EntityManager entityManager;
    public Inventory getInHouseStock(Product product) {
        entityManager.find(Product.class,new Product());
        return new Inventory();
    }

    public boolean update(Product product, Inventory inventory, Integer quantity) {
        return true;
    }
}

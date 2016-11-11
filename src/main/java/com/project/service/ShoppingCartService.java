package com.project.service;

import com.project.domain.Customer;
import com.project.domain.Product;
import com.project.domain.ShoppingCart;
import com.project.service.exception.CannotAddToCartException;

import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
public class ShoppingCartService {
    private Customer customer;
    private ShoppingCart shoppingCart;

    @Inject
    private InventoryService inventoryService;

    public void addProduct(Product product) {
        try {
            inventoryService.getProductInventoryDetails(product);
            shoppingCart.addProduct(product);
        } catch (Exception e) {
            throw new CannotAddToCartException(e);
        }
    }

    public ShoppingCart getShoppingCart(String shoppingCardId,String customer){
        return null;
    }
}

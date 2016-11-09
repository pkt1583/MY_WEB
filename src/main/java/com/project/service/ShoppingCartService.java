package com.project.service;

import com.project.domain.Customer;
import com.project.domain.Product;
import com.project.domain.ShoppingCart;
import com.project.service.exception.CannotAddToCartException;

import javax.ejb.Stateful;

@Stateful
public class ShoppingCartService {
    private Customer customer;
    private ShoppingCart shoppingCart;

    public void addProduct(Product product) {
        try {
            shoppingCart.addProduct(product);
        } catch (Exception e) {
            throw new CannotAddToCartException(e);
        }
    }
}

package com.project.controller;

import com.project.domain.Product;
import com.project.domain.ShoppingCart;
import com.project.exception.InsufficientQuatityException;
import com.project.exception.ShoppingCartUpdateFailedException;
import com.project.service.ShoppingCartService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class ShoppingCartController implements Serializable {

    @EJB
    private ShoppingCartService shoppingCartService;

    private ShoppingCart shoppingCart = new ShoppingCart();

    private double totalAmount = 0.0;

    public String addProductToCart(Product product, Integer quantity) {
        try {
            this.shoppingCart = shoppingCartService.addProduct(product, quantity);
        } catch (InsufficientQuatityException e) {
            return "errorAddingToCart";
        }
        return "";
    }

    public String updateCart(Product product, Integer quantity) {
        try {
            this.shoppingCart = shoppingCartService.updateProduct(product, quantity);
        } catch (InsufficientQuatityException e) {
            return "errorAddingToCart";
        } catch (ShoppingCartUpdateFailedException e) {
            return "errrorUpdatingCart";
        }
        return null;

    }


    public String checkout() {
        return "checkout";
    }
}

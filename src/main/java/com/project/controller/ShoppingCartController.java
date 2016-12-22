package com.project.controller;

import com.project.domain.OrderLineItem;
import com.project.domain.Product;
import com.project.domain.ShoppingCart;
import com.project.service.InventoryService;
import com.project.service.OrderService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SessionScoped
@Named
public class ShoppingCartController implements Serializable {
    @EJB
    private InventoryService inventoryService;

    @EJB
    private OrderService orderService;

    private ShoppingCart shoppingCart =new ShoppingCart();

    private double totalAmount=0.0;
    public void addProductToCart(Product product,Integer quantity){
        if(inventoryService.isProductAvailable(product)){
            this.shoppingCart= orderService.addProductToOrderLineItem(shoppingCart,product,quantity);
            totalAmount=totalAmount+1.0; //should be product getCost
        }
    }


    public void checkout(){
        orderService.checkout(shoppingCart);
    }
}

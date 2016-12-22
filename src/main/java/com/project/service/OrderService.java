package com.project.service;

import com.project.dao.OrderDao;
import com.project.domain.OrderLineItem;
import com.project.domain.Product;
import com.project.domain.ProductOrder;
import com.project.domain.ShoppingCart;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OrderService {

    @Inject
    private OrderDao orderDao;


    public ShoppingCart addProductToOrderLineItem(ShoppingCart shoppingCart, Product product,Integer quantity) {
        ShoppingCart shoppingCart1=new ShoppingCart();
        shoppingCart.copyTo(shoppingCart1);
        OrderLineItem orderLineItem=new OrderLineItem();
        orderLineItem.setProduct(product);
        orderLineItem.setQuantity(quantity);
        shoppingCart1.addOrderLineItem(orderLineItem);
        return shoppingCart1;
    }

    public String  checkout(ShoppingCart shoppingCart) {
        ProductOrder productOrder=orderDao.createOrder(shoppingCart);
        if(productOrder!=null){
            return "payment";
        }
        return null;
    }
}

package com.project.service;

import com.project.dao.OrderDao;
import com.project.domain.ProductOrder;
import com.project.domain.ShoppingCart;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OrderService {

    @Inject
    private OrderDao orderDao;


    public ProductOrder createOrder(ShoppingCart cart) {
        ProductOrder productOrder = orderDao.createOrder(cart);
        return productOrder;
    }

    public void finalizeOrder(ProductOrder order) {

    }

    public void releaseOrder(ProductOrder productOrder) {
        orderDao.releaseOrder(productOrder);
    }
}

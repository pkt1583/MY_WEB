package com.project.controller;

import com.project.domain.ProductOrder;
import com.project.domain.ShoppingCart;
import com.project.exception.ShippingUpdateException;
import com.project.service.OrderService;
import com.project.service.ShippingService;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;

@ManagedBean
public class CheckoutController {

    @EJB
    private OrderService orderService;

    @EJB
    private ShippingService shippingService;

    public String performCheckout(ShoppingCart cart){
        ProductOrder order=orderService.createOrder(cart);
        return "shippingDetailsEntry";
    }

    public String processShippingDetails(ProductOrder order){
        try {
            ProductOrder orderWithShippingCost=shippingService.update(order);
        } catch (ShippingUpdateException e) {
            return "shippingDetailsEntry";
        }
        return "orderSummary";
    }

    public String proceedToPayment(ProductOrder order){
        return "paymentEntry";
    }


}

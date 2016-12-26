package com.project.dao;

import com.project.domain.Product;
import com.project.domain.ProductOrder;
import com.project.domain.ShoppingCart;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class OrderDao {

    @Inject
    private BaseDao baseDao;

    public ProductOrder createOrder(ShoppingCart shoppingCart) {
        ProductOrder productOrder=new ProductOrder();
        productOrder.setOrderLineItems(shoppingCart.getOrderLineItems());
        productOrder.setCustomer(shoppingCart.getCustomer());
        productOrder.setPaymentCompleted(false);
         baseDao.save(productOrder);
         return null;
        
    }
}

package com.project.dao;

import com.project.annotation.DbEntitymanager;
import com.project.domain.Product;
import com.project.domain.ProductOrder;
import com.project.domain.ShoppingCart;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class OrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    public ProductOrder createOrder(ShoppingCart shoppingCart) {
        ProductOrder productOrder=new ProductOrder();
        productOrder.setOrderLineItems(shoppingCart.getOrderLineItems());
        productOrder.setCustomer(shoppingCart.getCustomer());
        productOrder.setPaymentCompleted(false);
         entityManager.persist(productOrder);
         return productOrder;
        
    }

    public void releaseOrder(ProductOrder productOrder) {
        entityManager.persist(productOrder);
    }
}

package com.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ShoppingCart {
    @Id
    private Integer shopppingCardId;

    @OneToOne
    private Customer customer;
    @OneToMany
    private Set<OrderLineItem> orderLineItems = new HashSet<>();
    @OneToOne
    private ProductOrder productOrder;

    public Set<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public ProductOrder getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrder = productOrder;
    }

    public Integer getShopppingCardId() {
        return shopppingCardId;
    }

    public void setShopppingCardId(Integer shopppingCardId) {
        this.shopppingCardId = shopppingCardId;
    }


    public void addOrderLineItem(OrderLineItem orderLineItem) {
        this.orderLineItems.add(orderLineItem);
    }
}

package com.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//should this be entity
@Entity
public class OrderLineItem {
    @Id
    private Integer orderLineItemId;
    @OneToOne
    private Product product;

    @ManyToOne
    private ProductOrder productOrder;
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getOrderLineItemId() {
        return orderLineItemId;
    }

    public void setOrderLineItemId(Integer orderLineItemId) {
        this.orderLineItemId = orderLineItemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}

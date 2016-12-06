package com.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    private Integer shopppingCardId;

    @OneToOne
    private Customer customer;

    @OneToMany
    private List<Product> products=new ArrayList<>();


    @OneToOne
    private ProductOrder productOrder;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public void addProduct(Product product) {
        this.products.add(product);
    }
}

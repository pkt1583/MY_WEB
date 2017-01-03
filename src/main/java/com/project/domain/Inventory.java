package com.project.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Inventory implements Serializable {

    @Id
    private Integer InventoryId;
    @Basic
    private int quatity;

    @OneToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int currentStock) {
        this.quatity = currentStock;
    }

    public Integer getInventoryId() {
        return InventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        InventoryId = inventoryId;
    }
}

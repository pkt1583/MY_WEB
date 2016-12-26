package com.project.service;

import com.project.domain.Inventory;
import com.project.domain.Product;

import javax.ejb.Stateless;

@Stateless(name = "InventoryService")
public class InventoryService {

    public InventoryService(){}

    public Inventory getProductInventoryDetails(Product product) {
        //This will check Manufacturer inventory as well as BigSmokes Inventory
        return new Inventory();
    }

    public synchronized Inventory isProductAvailable(Product product) {
        Inventory inventory=getProductInventoryDetails(product);
        return inventory;
    }

    public void updateProduct(Inventory inventory,Integer quantity) {
        inventory.getProduct().setQuatity(quantity);
        //find product and reduce inventory by 1
    }
}

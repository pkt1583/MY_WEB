package com.project.service;

import com.project.domain.Inventory;
import com.project.domain.Product;

import javax.ejb.Stateless;

@Stateless(name = "InventoryService")
public class InventoryService {

    public InventoryService(){}

    public Inventory getProductInventoryDetails(Product product) {
        //This will check Manufacturer inventory as well as BigSmokes Inventory
        return null;
    }

    public boolean isProductAvailable(Product product) {
        Inventory inventory=getProductInventoryDetails(product);
        return false;
    }
}

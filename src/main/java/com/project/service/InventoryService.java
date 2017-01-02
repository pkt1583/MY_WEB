package com.project.service;

import com.project.dao.InventoryDao;
import com.project.domain.Inventory;
import com.project.domain.Product;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "InventoryService")
public class InventoryService {

    @EJB
    private ManufacturerService manufacturerService;

    @EJB
    private InventoryDao inventoryDao;
    public InventoryService(){}

    public Inventory getProductInventoryDetails(Product product) {
        Inventory inventory=new Inventory();
        inventoryDao.getInHouseStock(product);
        manufacturerService.getManufacturerInnventory(product);
        //merge both inventory
        return new Inventory();
    }


    public void updateProduct(Product product,Inventory inventory,Integer quantity) {
       inventoryDao.update(product,inventory,quantity);
        //find product and reduce inventory by 1
    }
}

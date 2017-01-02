package com.project.service;

import com.project.domain.Inventory;
import com.project.domain.Product;

import javax.ejb.EJB;

@EJB
public class ManufacturerService {

    public Inventory getManufacturerInnventory(Product product) {
        //sync call to JMS. This is bottleneck
        return new Inventory();
    }
}

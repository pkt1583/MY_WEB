package com.project.service;

import com.project.dao.ShippingDao;
import com.project.domain.ProductOrder;
import com.project.exception.ShippingUpdateException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ShippingService {
    @EJB
    private ShippingDao shippingDao;
    public ProductOrder update(ProductOrder order) throws ShippingUpdateException {
        try {
            order.setShippingCost(calculateShippingCost(order));
            shippingDao.saveShippingDetails(order.getShippingDetails());
            return order;
        }catch (Exception e){
            throw new ShippingUpdateException("Error occured in update shipping. Please retry");
        }
    }


    public double calculateShippingCost(ProductOrder order){
        return 0.0;

    }

    public void sendToShipping(ProductOrder productOrder) {
        shippingDao.updateShippingInfo(productOrder);
    }
}

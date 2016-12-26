package com.project.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShippingDetails {

    @Id
    private Integer ShippingDetailsId;

    @OneToOne
    private ProductOrder order;

    public Integer getShippingDetailsId() {
        return ShippingDetailsId;
    }

    public void setShippingDetailsId(Integer shippingDetailsId) {
        ShippingDetailsId = shippingDetailsId;
    }
}

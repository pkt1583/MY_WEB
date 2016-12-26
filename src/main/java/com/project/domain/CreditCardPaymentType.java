package com.project.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class CreditCardPaymentType extends PaymentType {

    @Basic
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

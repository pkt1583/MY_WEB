package com.project.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class CreditCardPaymentType extends PaymentType {

    @Basic
    private String creditCardNumber;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}

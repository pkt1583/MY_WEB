package com.project.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class DebitCardPaymentType extends PaymentType {
    @Basic
    private String debitCardNumber;

    public String getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }
}

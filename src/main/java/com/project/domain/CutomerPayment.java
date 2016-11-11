package com.project.domain;

import javax.persistence.*;

@Entity
public class CutomerPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String customerPaymentId;

    @OneToOne
    private Customer customer;
    @OneToOne

    private Payment payment;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getCustomerPaymentId() {
        return customerPaymentId;
    }

    public void setCustomerPaymentId(String customerPaymentId) {
        this.customerPaymentId = customerPaymentId;
    }
}

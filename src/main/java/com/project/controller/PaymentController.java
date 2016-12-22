package com.project.controller;

import com.project.domain.Payment;
import com.project.domain.PaymentType;
import com.project.domain.ProductOrder;
import com.project.service.PaymentService;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@ManagedBean
@RequestScoped
public class PaymentController {

    @Inject
    private ProductOrder productOrder;

    @EJB
    private PaymentService paymentService;

    private Set<PaymentType> paymentTypes = new HashSet<>();

    private PaymentType selectedPaymentType;

    private Payment paymentInfo;

    @PostConstruct
    public void loadPaymentType() {
        paymentTypes.addAll(paymentService.getPaymentTypes());
    }

    public String doPayment() {
        paymentInfo.setPaymentType(selectedPaymentType);
        if (paymentService.processPayment(paymentInfo)) {
            return "paymentSuccess";
        }
        return "paymentFailure";
    }

}

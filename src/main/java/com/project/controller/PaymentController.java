package com.project.controller;

import com.project.domain.Payment;
import com.project.exception.PaymentNotAuthorizedException;
import com.project.service.OrderService;
import com.project.service.PaymentService;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class PaymentController implements Serializable {

    @EJB
    private PaymentService paymentService;

    @EJB
    private OrderService orderService;

    public String processPayment(Payment payment) {
        try {
            paymentService.processPayment(payment);
            paymentService.updatePaymentInfo(payment);
        } catch (PaymentNotAuthorizedException e) {
            return "payment";
        }
        return "success";
    }

}

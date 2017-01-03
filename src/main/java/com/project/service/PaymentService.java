package com.project.service;

import com.project.dao.PaymentDao;
import com.project.domain.Payment;
import com.project.exception.PaymentNotAuthorizedException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PaymentService {

    @EJB
    private PaymentAuthorizationService paymentAuthorizationService;

    @EJB
    private EmailService emailService;

    @EJB
    private ShippingService shippingService;

    @EJB
    private OrderService orderService;

    @EJB
    private PaymentDao paymentDao;

    public boolean processPayment(Payment paymentInfo) throws PaymentNotAuthorizedException {
        if (!authorizedPayment(paymentInfo)) {
            throw new PaymentNotAuthorizedException("Payment is not authorized");
        } else {
            paymentDao.updatePaymant(paymentInfo);
            emailService.sendConfirmation(paymentInfo);
            orderService.releaseOrder(paymentInfo.getProductOrder());
            shippingService.sendToShipping(paymentInfo.getProductOrder());
        }
        return true;
    }

    private boolean authorizedPayment(Payment payment) {
        return true;
    }

    public void updatePaymentInfo(Payment payment) {

    }
}

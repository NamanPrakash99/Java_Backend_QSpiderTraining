package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcess {

    private final PaymentService paymentService;

    @Autowired
    private TransactionLogger logger;

    // Constructor Injection
    public PaymentProcess(@Qualifier("upiPayment") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void makePayment(double amount) {
        paymentService.processPayment(amount);
        logger.logTransaction("Payment processed successfully");
    }
}
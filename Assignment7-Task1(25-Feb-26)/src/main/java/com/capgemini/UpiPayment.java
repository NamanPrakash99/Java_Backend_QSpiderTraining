package com.capgemini;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements PaymentService {

    private final TransactionLogger logger;

    public UpiPayment(TransactionLogger logger) {
        this.logger = logger;
        System.out.println("UpiPayment Bean Created");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment doen using upi : ₹" + amount);
        logger.logTransaction("UPI payment of ₹" + amount);
    }
}

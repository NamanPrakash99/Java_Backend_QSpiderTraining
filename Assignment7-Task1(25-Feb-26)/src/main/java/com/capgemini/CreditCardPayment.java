package com.capgemini;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCardPayment implements PaymentService {

	private final TransactionLogger logger;

	public CreditCardPayment(TransactionLogger logger) {
		this.logger = logger;
		System.out.println("CreditCardPayment Bean");
	}

	@Override
	public void processPayment(double amount) {
		System.out.println("Payment done using Credit Card: ₹" + amount);
		logger.logTransaction("Credit Card payment of ₹" + amount);
	}
}

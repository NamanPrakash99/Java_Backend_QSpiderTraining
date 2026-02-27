package com.Assignment7;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CreditScoreValidator implements LoanValidator {

    @Override
    public boolean validateLoan(double amount) {
        System.out.println("Validating loan using Credit Score rules...");
        return amount <= 500000;   
    }
}

package com.Assignment7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class LoanService {

    private final LoanValidator loanValidator;
    private AuditService auditService;

    // Constructor Injection
    public LoanService(@Qualifier("incomeValidator") LoanValidator loanValidator) {
        this.loanValidator = loanValidator;
    }

    // Setter Injection
    @Autowired
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void processLoan(double amount) {
        boolean approved = loanValidator.validateLoan(amount);

        if (approved) {
            System.out.println("Loan Approved for amount: " + amount);
            auditService.log("Loan Approved for: " + amount);
        } else {
            System.out.println("Loan Rejected for amount: " + amount);
            auditService.log("Loan Rejected for: " + amount);
        }
    }
}

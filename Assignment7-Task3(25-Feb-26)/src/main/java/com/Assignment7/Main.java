package com.Assignment7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(BankAppConfig.class);

        LoanService loanService = context.getBean(LoanService.class);

        loanService.processLoan(400000);
        loanService.processLoan(1200000);

        context.close();
    }
}

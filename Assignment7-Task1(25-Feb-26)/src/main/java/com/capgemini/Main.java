package com.capgemini;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Configuration
@ComponentScan("com.capgemini")
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ioc= new AnnotationConfigApplicationContext(Main.class);

        PaymentProcess process = ioc.getBean(PaymentProcess.class);

        process.makePayment(5000);

        ioc.close();
    }
}

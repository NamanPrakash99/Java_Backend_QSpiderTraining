package com.capgemini;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.capgemini")
public class Main {

    public static void main(String[] args) {

        ApplicationContext ioc= new AnnotationConfigApplicationContext(Main.class);

        PaymentProcess process = ioc.getBean(PaymentProcess.class);

        process.makePayment(5000);

    }
}

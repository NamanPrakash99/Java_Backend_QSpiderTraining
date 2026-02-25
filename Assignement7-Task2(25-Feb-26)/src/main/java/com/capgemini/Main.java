package com.capgemini;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan("com.capgemini")
public class Main {

    public static void main(String[] args) {

        ApplicationContext ioc = new AnnotationConfigApplicationContext(Main.class);

        OrderService orderService = ioc.getBean(OrderService.class);
        orderService.placeOrder();

        (( AnnotationConfigApplicationContext) ioc).close();
    }
}

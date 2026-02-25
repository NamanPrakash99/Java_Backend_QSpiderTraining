package com.capgemini;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DeliveryService {

    @PostConstruct
    public void init() {
        System.out.println("Delivery Service initialized");
    }

    public void deliverOrder() {
        System.out.println("Order Out for Delivery");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Delivery Service Closed");
    }
}

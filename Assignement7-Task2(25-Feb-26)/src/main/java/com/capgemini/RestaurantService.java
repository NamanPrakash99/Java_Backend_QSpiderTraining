package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService {

    private DeliveryService deliveryService;

    public RestaurantService() {
        System.out.println("RestaurantService Bean Created");
    }

    // Setter Injection
    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void prepareOrder() {
        deliveryService.deliverOrder();
    }
}

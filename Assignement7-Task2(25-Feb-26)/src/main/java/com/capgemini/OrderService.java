package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private NotificationService notificationService;

    // Field Injection
    @Autowired
    private RestaurantService restaurantService;

    // Constructor Injection 
    public OrderService( @Qualifier("smsNotification") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void placeOrder() {
        restaurantService.prepareOrder();
        notificationService.sendNotification("Your order is on the way!");
    }
}

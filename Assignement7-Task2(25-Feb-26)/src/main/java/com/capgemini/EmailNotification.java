package com.capgemini;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotification implements NotificationService {

    public EmailNotification() {
        System.out.println("EmailNotification Bean Created");
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Email Sent: " + message);
    }
}

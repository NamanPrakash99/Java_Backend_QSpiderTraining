package com.class_level_config_BasicSpring.prac;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CreditCard implements Payment {
	

	@Override
    public void send() {
        System.out.println("Payment done using Credit Card");
    }
}

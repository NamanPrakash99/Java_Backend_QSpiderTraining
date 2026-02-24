package com.class_level_config_BasicSpring.prac;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UPI implements Payment {
	@Override
    public void send() {
        System.out.println("Payment done using UPI");
    }

}

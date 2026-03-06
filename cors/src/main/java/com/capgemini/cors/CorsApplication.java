package com.capgemini.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication

public class CorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorsApplication.class, args);
	}

}

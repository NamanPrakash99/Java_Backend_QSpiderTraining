package com.capgemini.springbootbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
public class SpringbootbasicApplication {

	public static void main(String[] args) {
		ApplicationContext ioc = SpringApplication.run(SpringbootbasicApplication.class, args);

		Doctor doc = ioc.getBean(Doctor.class);

		doc.check();
//		EntityManagerFactory emf = ioc.getBean(EntityManagerFactory.class);
//		System.out.println(emf);
		
		
//		@Bean
//		public OpenAPI getOpenAPI() {
//			return new OpenAPI();
//		}
		
	}

}

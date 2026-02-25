package com.capgemini;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class TransactionLogger {

	@PostConstruct
	public void init() {
		System.out.println("Logger initialized");
	}

	public void logTransaction(String message) {
		System.out.println("Transaction Log: " + message);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Logger destroyed");
	}
}

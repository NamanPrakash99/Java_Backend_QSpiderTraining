package com.capgemini.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(CategoryNotFound.class)
	public String handleException() {
		return "Category Not Found";
	}
	
	@ExceptionHandler(ProductNotFound.class)
	public String handleException1() {
		return "Product Not Found";
	}
	
	@ExceptionHandler(InvalidProductData.class)
	public String handleException2() {
		return "Invalid Product Data Found";
	}
}

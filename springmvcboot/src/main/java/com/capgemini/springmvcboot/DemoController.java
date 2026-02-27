package com.capgemini.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {
	
	@Autowired
	JpaRepository userjpa;
	
	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String createAccount() {
		return "register";
	}
	
	// fetching data using url
//	@PostMapping("/create-account")
//	public String register(HttpServletRequest request) {
//		String name=request.getParameter("name");
//		String email=request.getParameter("email");
//		String number=request.getParameter("number");
//		
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(number);
//		return "success";
//	}
	
	// fetching data from class
	@PostMapping("/create-account")
	public String register(@ModelAttribute Users users) {
		
//		System.out.println(users.getEmail());
//		System.out.println(users.getName());
//		System.out.println(users.getNumber());
		userjpa.save(users);
		
		return "success";
	}
}

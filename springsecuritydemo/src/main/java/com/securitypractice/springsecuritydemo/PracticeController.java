package com.securitypractice.springsecuritydemo;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class PracticeController {
	
	@GetMapping("/public")
	public String getDetails() {
		return "Details";
	}
	
	@GetMapping("/leader")
	public String UpadteUser() {
		return "Update";
	}
	
	@GetMapping("/admin")
	public String deleteUser() {
		return "Delete";
	}
	
	@GetMapping("/csfr-token")
	public CsrfToken  getCsrf(CsrfToken token) {
		return token;
	}
}

package com.Docker_prac;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class dockerController {

	@GetMapping("/api")
	public String demo() {
		return "Demo Controller";
	}
}

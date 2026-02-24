package com.class_level_config_BasicSpring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")
public class DemoConfiguration {
	
	@Bean
	public Scanner getScanner() {
		
		return new Scanner(System.in);
	}
	
	@Bean
	public List<String> getList(){
		return List.of("Miller","Brevis","Holder");
	}
	
	@Bean
	public HashMap<Integer, String> getMap() {
	    HashMap<Integer, String> map = new HashMap<>();
	    map.put(1, "Naman");
	    map.put(2, "Ravi");
	    return map;
	}
	
}

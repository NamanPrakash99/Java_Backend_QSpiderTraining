package com.securitypractice.springsecuritydemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	/**
	 * 
	 * Mobie
	 * --> 3, -->5
	 * --> 4
	 * brand
	 * color
	 * price
	 * ram
	 * processor
	 * design
	 * os
	 * camera
	 * pixel
	 * display
	 *
	 * 
	 */
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
		// singleton
		// builder design pattern(as per requirement u are creating the object)
		return http.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(auth->auth
				.requestMatchers("/practice").permitAll()
				//.requestMatchers("/admin").authenticated()
				.requestMatchers("/admin").hasRole("USER"))
				.httpBasic(Customizer.withDefaults())
				.build();
	}
	
	@Bean
	public UserDetailsService getUserDetails() {
		
		UserDetails admin= User
		.withUsername("admin")
		.password("{noop}1234")
		.roles("ADMIN")
		.build();
		
		
		UserDetails user=User.withUsername("Naman")
		.password("{noop}cr4lpa")
		.roles("USER").build();
		
		return new InMemoryUserDetailsManager(user);     // store in jvm memory
	}
	
	
}

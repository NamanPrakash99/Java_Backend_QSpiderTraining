package com.capgemini.springbootbasic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerJpaRepository custjpa;
	
	
	@PostMapping("/cust")
	public String createCustomer(@RequestBody Customer c) {
		Customer customer=custjpa.save(c);
		return customer.toString();
	}
	
	@GetMapping("/cust-email/{email}")
	public Customer getByEmail(@PathVariable String email) {
		return custjpa.findByEmail(email);
	}
	
	@GetMapping("/name-email/{name}/{email}")
    public Customer findByNameAndEmail(@PathVariable String name, @PathVariable String email) {
        return custjpa.findByNameAndEmail(name, email);
    }
	
//	@GetMapping("/name-email/{name}/{email}")
//    public Customer findByNameOrEmail(RequestParam String name, @PathVariable String email) {
//        return custjpa.findByNameOrEmail(name, email);
//    }
	
	@GetMapping("/id-between/{start}/{end}")
    public List<Customer> findByIdBetween(@PathVariable int start, @PathVariable int end) {
        return custjpa.findByIdBetween(start, end);
    }
	
	@GetMapping("/age-greater/{age}")
    public List<Customer> findByAgeGreaterThan(@PathVariable int age) {
        return custjpa.findByAgeGreaterThan(age);
    }
	
	@GetMapping("/id-less/{id}")
    public List<Customer> findByIdLessThan(@PathVariable int id) {
        return custjpa.findByIdLessThan(id);
    }
	
	@GetMapping("/no-email")
    public List<Customer> findByEmailIsNull() {
        return custjpa.findByEmailIsNull();
    }
	
	@GetMapping("/is-email")
    public List<Customer> findByEmailIsNotNull() {
        return custjpa.findByEmailIsNotNull();
    }
	
	@GetMapping("/name-contains/{keyword}")
    public List<Customer> findByNameContaining(@PathVariable String keyword) {
        return custjpa.findByNameContaining(keyword);
    }
	
	@GetMapping("/name-starts/{prefix}")
    public List<Customer> findByNameStartingWith(@PathVariable String prefix) {
        return custjpa.findByNameStartingWith(prefix);
    }

    @GetMapping("/name-ends/{suffix}")
    public List<Customer> findByNameEndingWith(@PathVariable String suffix) {
        return custjpa.findByNameEndingWith(suffix);
    }
	
    @GetMapping("/name-exact/{name}")
    public List<Customer> findByNameIgnoreCase(@PathVariable String name) {
        return custjpa.findByNameIgnoreCase(name);
    }

    @GetMapping("/find-top")
    public List<Customer> findTopByOrderByIdDesc() {
        return custjpa.findTopByOrderByIdDesc();
    }

    @GetMapping("/first-three/{name}")
    public List<Customer> findFirst3ByName(@PathVariable String name) {
        return custjpa.findFirst3ByName(name);
    }
	
	
}

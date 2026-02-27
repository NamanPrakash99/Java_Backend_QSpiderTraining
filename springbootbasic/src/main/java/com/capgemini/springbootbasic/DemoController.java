package com.capgemini.springbootbasic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/car")
@RestController
public class DemoController {
	
//	@GetMapping("/a")
//	@ResponseBody
	

	@Autowired
	CarJpaRepository carjpa;
	
	
	@PostMapping("/a")
	public List<String> hello() {
		return List.of("Miller","Brevis","Markaram","Rickleton");
	}
	
	
	@PostMapping("/add")
	public String createPlayer(@RequestBody Cricketer c) {
		System.out.println(c);
		return c.toString();
	}
	
//	@PostMapping("/car")
//	public String createCar(@RequestBody Car c) {
//		System.out.println(c);
//		return c.toString();
//	}
	
	@PostMapping("/create")
	public String createPerson(@RequestBody Person p) {
		System.out.println(p);
		return p.toString();
	}
	
	@PostMapping("/detail")
	public String createCollege(@RequestBody College s) {
		System.out.println(s);
		return s.toString();
	}
	
	@PostMapping("/car")
	public String createCar(@RequestBody Car c) {
		Car car=carjpa.save(c);
		return car.toString();
	}
	
	@GetMapping("/find-id")
//     http://localhost:8080/car/find-id?1
	public Car getById(@RequestParam int id) {
		Optional<Car> option=carjpa.findById(id);
		
		if(option.isPresent()) {
			Car c=option.get();
			return c;
		}else {
			throw new DataNotExist();
		}
	}
	
	@GetMapping("/find-all")
	public String findAll() {
	    List<Car> list = carjpa.findAll();
	    return !list.isEmpty() ? list.toString() : "No data found";
	}
	
	
	@DeleteMapping("/delete-id/{id}")
	public boolean deleteCar(@PathVariable int id) {
		Optional<Car> option=carjpa.findById(id);
		
		if(option.isPresent()) {
			carjpa.delete(option.get());
			return true;
		}else {
			return false;
		}
	}
	
	
	@PutMapping("/update-car/{id}")          // ->for full update
	public boolean updateCar(@PathVariable int id,@RequestBody Car c) {
		
		Optional<Car> option=carjpa.findById(id);
		if(option.isPresent()) {
			Car car=option.get();
			car.setBrand(c.getBrand());
			car.setPrice(c.getPrice());
			carjpa.save(car);
			return true;
		}else {
			return false;
		}
	}
	
	
	@PatchMapping("/update-car/{id}")                 // ->for partial update
	public boolean updateCarData(@PathVariable int id,@RequestBody Car c) {
		
		Optional<Car> option=carjpa.findById(id);
		if(option.isPresent()) {
			Car car=option.get();
			if(c.getBrand()!=null) {
				car.setBrand(c.getBrand());
			}
			else if(c.getPrice()!=0.0) {
				car.setPrice(c.getPrice());
			}
			carjpa.save(car);
			return true;
		}else {
			return false;
		}
	}
	
	
	
	// find detail using car price
	
	@GetMapping("/find-price/{price}")
	public Car getCarByPrice(@PathVariable double price) {
		return carjpa.getByPrice(price);
	}
	
	@DeleteMapping("/delete-brand/{brand}")
	public void deleteByBrand(@PathVariable String brand) {
		carjpa.deleteByBrand(brand);
	}
	
	
}

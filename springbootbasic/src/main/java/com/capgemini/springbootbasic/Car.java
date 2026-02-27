package com.capgemini.springbootbasic;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
	@Id
	private int id;
	private String brand;
	private double price;
//	Engine e;
//
//	public Engine getE() {
//		return e;
//	}
//
//	public void setE(Engine e) {
//		this.e = e;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", price=" + price + "]";
	}

}

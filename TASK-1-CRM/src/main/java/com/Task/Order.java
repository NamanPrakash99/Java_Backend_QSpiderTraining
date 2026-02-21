package com.Task;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders") 
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OrderId;
	private String Orderdate;
	private double totalAmount;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrder_id(int orderId) {
		OrderId = orderId;
	}

	public String getOrderdate() {
		return Orderdate;
	}

	public void setOrderdate(String orderdate) {
		Orderdate = orderdate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Order [Order_id=" + OrderId + ", Orderdate=" + Orderdate + ", totalAmount=" + totalAmount
				+ ", customer=" + customer + ", products=" + products + "]";
	}

	
}

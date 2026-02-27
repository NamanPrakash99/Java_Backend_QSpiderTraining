package com.capgemini.springbootbasic;

import java.util.List;

public class Person {
	private int id;
	private String name;
	private List<String> item;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getItem() {
		return item;
	}
	public void setItem(List<String> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", item=" + item + "]";
	}
	
	
}

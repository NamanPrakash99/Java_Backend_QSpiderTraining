package com.one_to_one_mapping;

import javax.persistence.Persistence;

public class User {
	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("postgres");

		
	}
}

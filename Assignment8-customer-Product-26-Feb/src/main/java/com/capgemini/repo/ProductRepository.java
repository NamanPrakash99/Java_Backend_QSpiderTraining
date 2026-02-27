package com.capgemini.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByCategory_CategoryId(Long categoryId);
    List<Product> findByProductNameContainingIgnoreCase(String name);
}

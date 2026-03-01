package com.capgemini.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Assignment.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}

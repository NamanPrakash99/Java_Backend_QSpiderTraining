package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.dto.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

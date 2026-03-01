package com.capgemini.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Assignment.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}

package com.capgemini.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Assignment.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}

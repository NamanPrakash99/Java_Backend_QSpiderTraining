package com.capgemini.springbootbasic;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer>{
	public Customer findByEmail(String email);
	public Customer findByNameAndEmail(String name,String email);
	public Customer findByNameOrEmail(String name,String email);
	List<Customer> findByIdBetween(int start, int end);
	List<Customer> findByAgeGreaterThan(int age);
	List<Customer> findByIdLessThan(int id);
	List<Customer> findByEmailIsNull();
	List<Customer> findByEmailIsNotNull();
	List<Customer> findByNameContaining(String keyword);
	List<Customer> findByNameStartingWith(String prefix);
	List<Customer> findByNameEndingWith(String suffix);
	List<Customer> findByNameIgnoreCase(String name);
	List<Customer> findTopByOrderByIdDesc();
	List<Customer> findFirst3ByName(String name);
	

}

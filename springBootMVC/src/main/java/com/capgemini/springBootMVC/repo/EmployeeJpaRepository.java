package com.capgemini.springBootMVC.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.springBootMVC.Entity.Employee;


@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, String> {
	 Employee findByEmail(String email);
    public Employee findByEmailAndPassword(String email, String password);

}

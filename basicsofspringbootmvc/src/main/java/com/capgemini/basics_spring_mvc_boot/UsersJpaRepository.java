package com.capgemini.basics_spring_mvc_boot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepository extends JpaRepository<Users, Integer> {

    public Users findByEmailAndPassword(String email, String password);

}

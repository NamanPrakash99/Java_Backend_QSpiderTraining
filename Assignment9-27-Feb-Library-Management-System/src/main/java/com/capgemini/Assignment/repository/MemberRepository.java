package com.capgemini.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.Assignment.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}

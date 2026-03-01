package com.capgemini.Assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.Assignment.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    // Fetch all loans of a specific member
    List<Loan> findByMemberMemberId(Long memberId);
}
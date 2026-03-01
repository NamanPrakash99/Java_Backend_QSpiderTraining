package com.capgemini.Assignment.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.capgemini.Assignment.entity.Loan;
import com.capgemini.Assignment.service.LoanService;

@RestController
@RequestMapping("/api/v1/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/issue")
    public ResponseEntity<Loan> issueBook(@RequestParam Long memberId,
                                          @RequestParam Long bookId,
                                          @RequestParam
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                          LocalDate dueDate) {

        return ResponseEntity.ok(
                loanService.issueBook(memberId, bookId, dueDate));
    }

    @PutMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable Long loanId) {
        return ResponseEntity.ok(
                loanService.returnBook(loanId));
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<Loan> getLoan(@PathVariable Long loanId) {
        return ResponseEntity.ok(
                loanService.getLoanById(loanId));
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }
}
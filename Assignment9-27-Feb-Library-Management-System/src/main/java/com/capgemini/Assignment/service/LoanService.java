package com.capgemini.Assignment.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import com.capgemini.Assignment.entity.Book;
import com.capgemini.Assignment.entity.Loan;
import com.capgemini.Assignment.entity.Member;
import com.capgemini.Assignment.exception.ResourceNotFoundException;
import com.capgemini.Assignment.repository.BookRepository;
import com.capgemini.Assignment.repository.LoanRepository;
import com.capgemini.Assignment.repository.MemberRepository;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Loan not found with id: " + id));
    }

    @Transactional
    public Loan issueBook(Long memberId, Long bookId, LocalDate dueDate) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member not found with id: " + memberId));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + bookId));

        if (book.getCopiesAvailable() <= 0) {
            throw new RuntimeException("No available copies");
        }

        book.setCopiesAvailable(book.getCopiesAvailable() - 1);

        Loan loan = new Loan();
        loan.setMember(member);
        loan.setBook(book);
        loan.setIssueDate(LocalDate.now());
        loan.setDueDate(dueDate);
        loan.setLoanStatus("ISSUED");

        return loanRepository.save(loan);
    }

    @Transactional
    public Loan returnBook(Long loanId) {

        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Loan not found with id: " + loanId));

        if ("RETURNED".equals(loan.getLoanStatus())) {
            throw new RuntimeException("Book already returned");
        }

        loan.setReturnDate(LocalDate.now());

        if (loan.getReturnDate().isAfter(loan.getDueDate())) {
            loan.setLoanStatus("LATE");
        } else {
            loan.setLoanStatus("RETURNED");
        }

        Book book = loan.getBook();
        book.setCopiesAvailable(book.getCopiesAvailable() + 1);

        return loanRepository.save(loan);
    }

    public List<Loan> getLoansByMember(Long memberId) {

        memberRepository.findById(memberId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Member not found with id: " + memberId));

        return loanRepository.findByMemberMemberId(memberId);
    }
}
package com.capgemini.Assignment13.service;

import com.capgemini.Assignment13.entity.Book;
import com.capgemini.Assignment13.entity.BorrowRecord;
import com.capgemini.Assignment13.entity.User;
import com.capgemini.Assignment13.repo.BookRepository;
import com.capgemini.Assignment13.repo.BorrowRecordRepository;
import com.capgemini.Assignment13.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowRecordService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<BorrowRecord> getAllRecords() {
        return borrowRecordRepository.findAll();
    }

    @Transactional
    public BorrowRecord borrowBook(Long userId, Long bookId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Book is already borrowed");
        }

        book.setAvailable(false);
        bookRepository.save(book);

        BorrowRecord record = BorrowRecord.builder()
                .user(user)
                .book(book)
                .borrowDate(LocalDate.now())
                .returned(false)
                .build();

        return borrowRecordRepository.save(record);
    }

    @Transactional
    public BorrowRecord returnBook(Long bookId) {
        BorrowRecord record = borrowRecordRepository.findByBookIdAndReturned(bookId, false)
                .orElseThrow(() -> new RuntimeException("Active borrow record not found for this book"));

        record.setReturnDate(LocalDate.now());
        record.setReturned(true);

        Book book = record.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        return borrowRecordRepository.save(record);
    }
}

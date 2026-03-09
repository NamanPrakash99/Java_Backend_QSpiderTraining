package com.capgemini.Assignment13.controller;

import com.capgemini.Assignment13.entity.BorrowRecord;
import com.capgemini.Assignment13.service.BorrowRecordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/borrow")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @GetMapping
    public List<BorrowRecord> getAllRecords() {
        return borrowRecordService.getAllRecords();
    }

    @PostMapping("/{userId}/{bookId}")
    public BorrowRecord borrowBook(@PathVariable Long userId, @PathVariable Long bookId) {
        return borrowRecordService.borrowBook(userId, bookId);
    }

    @PostMapping("/return/{bookId}")
    public BorrowRecord returnBook(@PathVariable Long bookId) {
        return borrowRecordService.returnBook(bookId);
    }
}

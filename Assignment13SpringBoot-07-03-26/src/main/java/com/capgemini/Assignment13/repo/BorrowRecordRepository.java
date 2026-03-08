package com.capgemini.Assignment13.repo;

import com.capgemini.Assignment13.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    List<BorrowRecord> findByUserId(Long userId);
    List<BorrowRecord> findByBookId(Long bookId);
    Optional<BorrowRecord> findByBookIdAndReturned(Long bookId, boolean returned);
}

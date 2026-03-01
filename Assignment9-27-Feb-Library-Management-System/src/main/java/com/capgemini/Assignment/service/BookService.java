package com.capgemini.Assignment.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.Assignment.entity.Author;
import com.capgemini.Assignment.entity.Book;
import com.capgemini.Assignment.entity.Category;
import com.capgemini.Assignment.entity.LibraryBranch;
import com.capgemini.Assignment.exception.ResourceNotFoundException;
import com.capgemini.Assignment.repository.AuthorRepository;
import com.capgemini.Assignment.repository.BookRepository;
import com.capgemini.Assignment.repository.CategoryRepository;
import com.capgemini.Assignment.repository.LibraryBranchRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LibraryBranchRepository branchRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id));
    }

    public Book addBook(Book book, Long categoryId, Long branchId, List<Long> authorIds) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found with id: " + categoryId));

        LibraryBranch branch = branchRepository.findById(branchId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Branch not found with id: " + branchId));

        Set<Author> authors = authorIds.stream()
                .map(aid -> authorRepository.findById(aid)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Author not found with id: " + aid)))
                .collect(Collectors.toSet());

        book.setCategory(category);
        book.setBranch(branch);
        book.setAuthors(authors);
        book.setStatus("ACTIVE");

        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existing = getBookById(id);
        existing.setTitle(book.getTitle());
        existing.setIsbn(book.getIsbn());
        existing.setPublishYear(book.getPublishYear());
        existing.setCopiesTotal(book.getCopiesTotal());
        existing.setCopiesAvailable(book.getCopiesAvailable());
        existing.setStatus(book.getStatus());
        return bookRepository.save(existing);
    }

    public void deleteOrDisableBook(Long id) {
        Book existing = getBookById(id);
        existing.setStatus("INACTIVE");
        bookRepository.save(existing);
    }
}
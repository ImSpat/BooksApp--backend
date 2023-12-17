package com.example.booksapp.service;

import com.example.booksapp.exception.BookNotFoundException;
import com.example.booksapp.model.Book;
import com.example.booksapp.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public Book findBookById(Long id) throws BookNotFoundException {
        return bookRepository
                .findBookById(id)
                .orElseThrow(
                        () -> new BookNotFoundException("Book with ID: " + id + " was not found")
                );
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteBookById(id);
    }

}

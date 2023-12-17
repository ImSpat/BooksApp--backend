package com.example.booksapp.controller;

import com.example.booksapp.exception.BookNotFoundException;
import com.example.booksapp.model.Book;
import com.example.booksapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookService.findAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {
        try {
            Book bookById = bookService.findBookById(id);
            return new ResponseEntity<>(bookById, HttpStatus.OK);
        } catch (BookNotFoundException e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, "text/plain");
            return new ResponseEntity<>(e.getMessage(), headers, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

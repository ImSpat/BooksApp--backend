package com.example.booksapp.model;

import jakarta.persistence.Entity;

import java.time.Year;

@Entity
public class Book extends Publication {

    public static final String TYPE = "Book";
    private String author;
    private int pages;
    private String isbn;

    public Book() {
        super();
    }

    public Book(Year year, String title, String publisher, String imageUrl, String author, int pages, String isbn) {
        super(year, title, publisher, imageUrl);
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", pages=" + pages +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

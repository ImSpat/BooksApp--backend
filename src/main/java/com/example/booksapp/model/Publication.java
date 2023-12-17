package com.example.booksapp.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Year;

@MappedSuperclass
public abstract class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Year year;
    private String title;
    private String publisher;
    private String imageUrl;

    public Publication() {
    }

    public Publication(Year year, String title, String publisher, String imageUrl) {
        this.year = year;
        this.title = title;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

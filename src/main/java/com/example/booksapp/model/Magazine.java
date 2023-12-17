package com.example.booksapp.model;

import jakarta.persistence.Entity;

import java.time.MonthDay;
import java.time.Year;

@Entity
public class Magazine extends Publication {

    public static final String TYPE = "Magazine";
    private MonthDay monthDay;
    private String language;

    public Magazine() {

    }

    public Magazine(Year year, String title, String publisher, String imageUrl, MonthDay monthDay, String language) {
        super(year, title, publisher, imageUrl);
        this.monthDay = monthDay;
        this.language = language;
    }


    public MonthDay getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(MonthDay monthDay) {
        this.monthDay = monthDay;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "monthDay=" + monthDay +
                ", language='" + language + '\'' +
                '}';
    }
}

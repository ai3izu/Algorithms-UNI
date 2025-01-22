package StrukturyDanych.Abstrakcyjne.Stos;

public class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "title='" + title + '\'' + '}';
    }
}

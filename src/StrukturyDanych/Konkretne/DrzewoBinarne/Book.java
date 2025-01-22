package StrukturyDanych.Konkretne.DrzewoBinarne;

import java.util.Objects;

public class Book {
    private int rokWydania;
    private String tytuł;
    private String autor;

    public Book(int rokWydania, String tytuł, String autor) {
        this.rokWydania = rokWydania;
        this.tytuł = tytuł;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return rokWydania + tytuł + autor;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return rokWydania == book.rokWydania && Objects.equals(tytuł, book.tytuł) && Objects.equals(autor, book.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rokWydania, tytuł, autor);
    }
}

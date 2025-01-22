package StrukturyDanych.Konkretne.TablicaHaszujaca;

import java.util.Objects;

public class Square {
    private int a;
    private int b;

    public Square(int a, int b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return a == square.a && b == square.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "Square{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

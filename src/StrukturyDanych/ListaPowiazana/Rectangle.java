package StrukturyDanych.ListaPowiazana;

public class Rectangle {
    private final int a;
    private final int b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getArea() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Prostokąt{" + "a=" + a + ", b=" + b + ", pole=" + getArea() + '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return  true;
        if(o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return  a == rectangle.a && b == rectangle.b;
    }
}

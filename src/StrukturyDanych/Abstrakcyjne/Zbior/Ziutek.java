package StrukturyDanych.Abstrakcyjne.Zbior;

public class Ziutek {
    private final String name;
    private final String surname;

    public Ziutek(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Ziutek{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}' + "\n";
    }
}

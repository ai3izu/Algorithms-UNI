package StrukturyDanych.Abstrakcyjne.Kolejka;

public class Mushroom {
    private final String name;
    private final int victims;

    public Mushroom(String name, int victims) {
        this.name = name;
        this.victims = victims;
    }

    @Override
    public String toString() {
        return "Mushroom{" + "name='" + name + '\'' + ", victims=" + victims + '}';
    }
}

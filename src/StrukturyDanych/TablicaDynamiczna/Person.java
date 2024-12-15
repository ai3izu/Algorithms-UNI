package StrukturyDanych.TablicaDynamiczna;

import java.util.Objects;

public class Person implements Comparable<Person> {
    int age;
    String name;
    String surname;

    public Person(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + ", surname='" + surname + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int compareTo(Person o) {
        int surnameCompare = this.surname.compareTo(o.surname);
        if (surnameCompare == 0) {
            return this.name.compareTo(o.name);
        } else {
            return surnameCompare;
        }
    }
}

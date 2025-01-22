package StrukturyDanych.Abstrakcyjne.Stos;

import java.util.LinkedList;

public class CustomStackObj {
    private final LinkedList<Book> stack;

    public CustomStackObj() {
        this.stack = new LinkedList<>();
    }

    public static void main(String[] args) {
        CustomStackObj stack1 = new CustomStackObj();
        Book k1 = new Book("Ksiazka 1");
        Book k2 = new Book("Ksiazka 2");
        Book k3 = new Book("Ksiazka 3");
        Book k4 = new Book("Ksiazka 4");
        Book k5 = new Book("Ksiazka 5");

        System.out.println(stack1.empty());
        stack1.push(k1);
        stack1.push(k2);
        stack1.push(k3);
        stack1.push(k4);
        stack1.push(k5);
        stack1.display();
        System.out.println(stack1.search(k2));

        stack1.pop();
        stack1.display();
        System.out.println(stack1.peek());

    }

    public boolean empty() {
        return this.stack.isEmpty();
    }

    public void push(Book elem) {
        this.stack.addFirst(elem);
    }

    public void pop() {
        this.stack.removeFirst();
    }

    public Book peek() {
        if (this.stack.isEmpty()) {
            System.out.println("Stos jest pusty");
            return null;
        }
        return this.stack.getFirst();
    }

    public int search(Book elem) {
        return this.stack.indexOf(elem);
    }

    public void display() {
        System.out.println(this.stack);
    }
}

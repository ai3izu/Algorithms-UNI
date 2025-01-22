package StrukturyDanych.Abstrakcyjne.Stos;

import java.util.LinkedList;

public class CustomStack<T> {
    private final LinkedList<T> stack;

    public CustomStack() {
        this.stack = new LinkedList<>();
    }

    public static void main(String[] args) {
        CustomStack<Integer> stack1 = new CustomStack<>();
        System.out.println(stack1.peek());

        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);

        System.out.println(stack1.empty());

        stack1.display();
        System.out.println(stack1.search(2));

        stack1.pop();
        stack1.display();
        System.out.println(stack1.peek());

    }

    public boolean empty() {
        return this.stack.isEmpty();
    }

    public void push(T elem) {
        this.stack.addFirst(elem);
    }

    public void pop() {
        this.stack.removeFirst();
    }

    public T peek() {
        if (this.stack.isEmpty()) {
            System.out.println("Stos jest pusty");
            return null;
        }
        return this.stack.getFirst();
    }

    public int search(T elem) {
        return this.stack.indexOf(elem);
    }

    public void display() {
        System.out.println(this.stack);
    }
}

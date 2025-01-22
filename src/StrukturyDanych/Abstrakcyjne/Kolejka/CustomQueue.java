package StrukturyDanych.Abstrakcyjne.Kolejka;

import java.util.LinkedList;

public class CustomQueue<T> {
    private final LinkedList<T> list;

    public CustomQueue() {
        this.list = new LinkedList<>();
    }

    public static void main(String[] args) {
        CustomQueue<Integer> queue = new CustomQueue<>();
        System.out.println(queue.empty());
        for (int i = 1; i <= 5; i++) {
            queue.offer(i);
        }
        queue.display();
        queue.poll();
        queue.display();
        System.out.println(queue.peek());
        System.out.println(queue.get(0));
    }

    public void offer(T elem) {
        this.list.add(elem);
    }

    public void poll() {
        if (this.list.isEmpty()) {
            return;
        }
        this.list.removeFirst();
    }

    public T peek() {
        if (this.list.isEmpty()) {
            return null;
        }
        return this.list.getFirst();
    }

    public T get(int index) {
        if (index < 0 || index >= this.list.size()) {
            return null;
        }
        return this.list.get(index);
    }

    public boolean empty() {
        return this.list.isEmpty();
    }

    public void display() {
        System.out.println(this.list);
    }
}

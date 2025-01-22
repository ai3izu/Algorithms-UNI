package StrukturyDanych.Abstrakcyjne.Kolejka;

import java.util.LinkedList;

public class CustomQueueObj {
    private final LinkedList<Mushroom> list;

    public CustomQueueObj() {
        this.list = new LinkedList<>();
    }

    public static void main(String[] args) {
        CustomQueueObj queueObj = new CustomQueueObj();
        Mushroom m1 = new Mushroom("Muchomor",1);
        Mushroom m2 = new Mushroom("Borowik",2);
        Mushroom m3 = new Mushroom("Sergiusz",3);
        Mushroom m4 = new Mushroom("PieczArka",4);
        System.out.println(queueObj.empty());

        queueObj.offer(m1);
        queueObj.offer(m2);
        queueObj.offer(m3);
        queueObj.offer(m4);


        queueObj.display();
        queueObj.poll();
        queueObj.display();
        System.out.println(queueObj.peek());
        System.out.println(queueObj.get(2));
    }

    public void offer(Mushroom elem) {
        this.list.add(elem);
    }

    public void poll() {
        if (this.list.isEmpty()) {
            return;
        }
        this.list.removeFirst();
    }

    public Mushroom peek() {
        if (this.list.isEmpty()) {
            return null;
        }
        return this.list.getFirst();
    }

    public Mushroom get(int index) {
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

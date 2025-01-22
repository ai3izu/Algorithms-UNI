package StrukturyDanych.Konkretne.ListaPowiazana;

public class Node {
    public int value;
    public Node next;

    Rectangle rectangle;

    public Node(int value) {
        this.value = value;
    }

    public Node(Rectangle rectangle){
        this.rectangle = rectangle;
    }
    @Override
    public String toString() {
        return "Node(" + this.value + ")";
    }
}

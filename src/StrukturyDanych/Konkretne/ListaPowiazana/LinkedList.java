package StrukturyDanych.Konkretne.ListaPowiazana;

public class LinkedList {
    private Node first;
    private int size;

    public LinkedList() {
        this.size = 0;
        this.first = null;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(3);
        list.addFirst(5);
        list.addFirst(7);

        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.find(5);
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);

        Node prevFirst = this.first;
        this.first = newNode;
        newNode.next = prevFirst;

        this.size++;
    }
    public void find(int value){
        Node currentNode = this.first;
        int index = 0;
        while (currentNode != null){
            if (currentNode.value == value){
                System.out.println("Wartosc " + value + " znaleziona na indeksie " + index);
            }
            currentNode = currentNode.next;
            index++;
        }
    }

    public void removeFirst(){
        if (this.first == null) throw new IllegalStateException("Nie mozna usunac z pustej listy");
        int removedValue = this.first.value;
        this.first = this.first.next;
        this.size--;

    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[ ");

        Node currentNode = this.first;
        for (int i = 0; i < this.size; i++) {
            text.append(currentNode.value).append(" ");
            currentNode = currentNode.next;
        }

        return text + "]";
    }
}

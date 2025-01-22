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
//        list.addFirst(3);
//        list.addFirst(5);
//        list.addFirst(7);
//
//        System.out.println(list);
//        list.removeFirst();
//        System.out.println(list);
//        list.find(5);

        list.add(3);
        list.add(5);
        list.add(1);
        list.add(2);
        list.removeLast();
        list.removeFirst();
        System.out.println(list);
    }

    // dodanie do przodu
    public void addFirst(int value) {
        Node newNode = new Node(value);

        Node prevFirst = this.first;
        this.first = newNode;
        newNode.next = prevFirst;

        this.size++;
    }

    // dodanie do konca opcjonalne bo nw czy to potrzebne dla powiazanej
    public void add(int value) {
        Node newNode = new Node(value);
        if (this.first == null) {
            this.first = newNode;
        }else {
            Node currentNode = this.first;
            while (currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        this.size++;
    }

    // find == indexOf
    public void find(int value) {
        Node currentNode = this.first;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.value == value) {
                System.out.println("Wartosc " + value + " znaleziona na indeksie " + index);
                return;
            }
            currentNode = currentNode.next;
            index++;
        }
    }
    public void removeLast(){
        if (this.first == null) throw new IllegalStateException("Nie mozna usunac z pustej listy");

        if(this.first.next == null){
            int removedValue = this.first.value;
            this.first = null;
            this.size --;
        }

        Node currentNode = this.first;
        while(currentNode.next.next != null){
            currentNode = currentNode.next;
        }

        int removedValue = currentNode.next.value;
        currentNode.next = null;
        this.size--;
    }
    public void removeFirst() {
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

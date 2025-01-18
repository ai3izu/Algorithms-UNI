package StrukturyDanych.ListaPowiazana;

public class LinkedObjectList {
    private  Node first;
    private  int size;

    public LinkedObjectList() {
        this.size = 0;
        this.first = null;
    }

    public static void main(String[] args) {
        LinkedObjectList list = new LinkedObjectList();

        list.addFirst(new Rectangle(5,5));
        list.addFirst(new Rectangle(2,3));
        list.addFirst(new Rectangle(1,10));
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);
        list.find(new Rectangle(1,10));
    }

    public void addFirst(Rectangle rectangle){
        Node newNode = new Node(rectangle);
        Node prevFirst = this.first;

        this.first = newNode;
        newNode.next = prevFirst;

        this.size ++;
    }
    public void removeFirst(){
        if (this.first == null) throw  new IllegalStateException("Nie mozna usunac z pustej listy");
        this.first = this.first.next;
        this.size --;
    }

    public void find(Rectangle rectangle){
        Node currentNode = this.first;
        int index = 0;
        boolean found = false;
        while(currentNode != null){
            if (currentNode.rectangle.equals(rectangle)){
                System.out.println("Trojkat " + rectangle + " znaleziony na indeksie " + index);
                found = true;
                break;
            }
            currentNode = currentNode.next;
            index ++;
        }
        if (!found) System.out.println("Prostokat " + rectangle  + " nie zostal znaleziony");
    }
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("[ ");

        Node currentNode = this.first;
        while (currentNode != null) {
            text.append(currentNode.rectangle).append(" ");
            currentNode = currentNode.next;
        }

        return text + "]";
    }
}

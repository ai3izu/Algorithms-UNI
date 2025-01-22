package StrukturyDanych.Konkretne.TablicaDynamiczna;

public class DynamicObjectArray {
    private Person[] tab = new Person[2];
    private int size = 0;

    public static void main(String[] args) {

        DynamicObjectArray dynamicArray = new DynamicObjectArray();
        dynamicArray.add(new Person(21, "Jan", "Kowalski"));
        dynamicArray.add(new Person(23, "Kamil", "Slimak"));
        dynamicArray.add(new Person(45, "Krzysztof", "Szczepan"));
        dynamicArray.add(new Person(56, "Karol", "Kaminski"));
        dynamicArray.add(new Person(76, "Jan", "Matejko"));

        dynamicArray.insertAt(0, new Person(66, "Fryderyk", "Chopin"));
        System.out.println(dynamicArray);

    }

    public void add(Person value) {
        if (this.size == this.tab.length) {
            Person[] newTab = new Person[this.size * 2];
            System.arraycopy(this.tab, 0, newTab, 0, this.tab.length);
            this.tab = newTab;
        }
        this.tab[this.size] = value;
        this.size++;
    }

    public void insertAt(int index, Person value) {
        if (index < 0 || index > this.size) {
            return;
        }
        if (this.size == this.tab.length) {
            Person[] newTab = new Person[this.size * 2];
            System.arraycopy(this.tab, 0, newTab, 0, this.tab.length);
            this.tab = newTab;
        }
        System.arraycopy(this.tab, index, this.tab, index + 1, this.size - index);
        this.tab[index] = value;
        this.size++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(" ");
        for (int i = 0; i < this.size; i++) {
            result.append(this.tab[i]).append(" ").append(" \n");
        }
        return result + " ";
    }
}

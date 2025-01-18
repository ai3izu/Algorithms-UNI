package StrukturyDanych.Konkretne.TablicaDynamiczna;

public class OrderedObjectDynamicArray {
    private Person[] tab = new Person[2];
    private int size = 0;

    public static void main(String[] args) {

        OrderedObjectDynamicArray dynamicArray = new OrderedObjectDynamicArray();
        dynamicArray.add(new Person(63, "Jan", "Kowalski"));
        dynamicArray.add(new Person(41, "Kamil", "Slimak"));
        dynamicArray.add(new Person(22, "Krzysztof", "Szczepan"));
        dynamicArray.add(new Person(25, "Adam", "Kowalski"));

        System.out.println(dynamicArray);
        System.out.println(dynamicArray.find(dynamicArray.tab, new Person(22, "Krzysztof", "Szczepan"), dynamicArray.size));

    }

    public void add(Person person) {
        if (this.size == this.tab.length) {
            Person[] newTab = new Person[this.size * 2];
            System.arraycopy(this.tab, 0, newTab, 0, this.tab.length);
            this.tab = newTab;
        }
        int index = this.size;
        for (int i = 0; i < this.size; i++) {
            if (this.tab[i].compareTo(person) > 0) {
                index = i;
                break;
            }
        }
        System.arraycopy(this.tab, index, this.tab, index + 1, this.size - index);
        this.tab[index] = person;
        this.size++;
    }

    public int find(Person[] tab, Person person, int size) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            Person middleValue = tab[middle];
            int comparison = middleValue.compareTo(person);

            if (comparison == 0) {
                return  middle;
            } else if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
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

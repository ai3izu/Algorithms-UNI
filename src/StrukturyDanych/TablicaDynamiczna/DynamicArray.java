package StrukturyDanych.TablicaDynamiczna;

public class DynamicArray {
    private int[] tab = new int[2];
    private int size = 0;

    public static void main(String[] args) {

        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);

        dynamicArray.insertAt(3, 6);
        dynamicArray.insertAt(0, 0);
        System.out.println(dynamicArray);
    }

    public void add(int value) {
        if (this.size == this.tab.length) {
            int[] newTab = new int[this.size * 2];
            System.arraycopy(this.tab, 0, newTab, 0, this.tab.length);
            this.tab = newTab;
        }
        this.tab[this.size] = value;
        this.size++;
    }

    public void insertAt(int index, int value) {
        if (index < 0 || index > this.size) {
            return;
        }
        if (this.size == this.tab.length) {
            int[] newTab = new int[this.size * 2];
            System.arraycopy(this.tab, 0, newTab, 0, this.tab.length);
            this.tab = newTab;
        }
        System.arraycopy(this.tab, index, this.tab, index + 1, this.size - index);
        this.tab[index] = value;
        this.size++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");
        for (int i = 0; i < this.size; i++) {
            result.append(this.tab[i]).append(" ");
        }
        return result + "]";
    }
}


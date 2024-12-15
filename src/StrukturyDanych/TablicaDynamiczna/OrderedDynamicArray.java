package StrukturyDanych.TablicaDynamiczna;

public class OrderedDynamicArray {
    private int[] tab = new int[2];
    private int size = 0;

    public static void main(String[] args) {

        OrderedDynamicArray dynamicArray = new OrderedDynamicArray();
        dynamicArray.add(4);
        dynamicArray.add(1);
        dynamicArray.add(3);
        dynamicArray.add(23);
        dynamicArray.add(5);

        System.out.println(dynamicArray);

        System.out.println(dynamicArray.find(dynamicArray.tab, 5, dynamicArray.size));
        System.out.println(dynamicArray.find(dynamicArray.tab, 3, dynamicArray.size));
    }

    public void add(int value) {
        if (this.size == this.tab.length) {
            int[] newTab = new int[this.size * 2];
            System.arraycopy(this.tab, 0, newTab, 0, this.tab.length);
            this.tab = newTab;
        }
        int index = this.size;
        for (int i = 0; i < this.size; i++) {
            if (this.tab[i] > value) {
                index = i;
                break;
            }
        }
        System.arraycopy(this.tab, index, this.tab, index + 1, this.size - index);
        this.tab[index] = value;
        this.size++;
    }

    public int find(int[] tab, int value, int size) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = tab[middle];

            if (middleValue == value) {
                return  middle;
            } else if (middleValue < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
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

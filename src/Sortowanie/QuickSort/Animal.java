package Sortowanie.QuickSort;

public class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Zwierze{" + name + '\'' + '}';
    }

    public String getName() {
        return name;
    }
}

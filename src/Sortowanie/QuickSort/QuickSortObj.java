package Sortowanie.QuickSort;

public class QuickSortObj {
    public static void main(String[] args) {
        Animal[] animals = {new Animal("Kot"), new Animal("Pies"), new Animal("Krowa"), new Animal("Kon"), new Animal("Papuga"), new Animal("Kaczka"), new Animal("Zebra"), new Animal("Antylopa")};
        System.out.println("Przed sortowaniem");
        for (Animal animal : animals) {
            System.out.print(animal + ", ");
        }

        // wywolanie quicksort
        quickSort(animals, 0, animals.length - 1);

        System.out.println("\nPo sortowaniu");

        for (Animal animal : animals) {
            System.out.print(animal + ", ");
        }
    }

    // Metoda do sortowania tablicy za pomocą QuickSort
    private static void quickSort(Animal[] animals, int start, int end) {
        if (start >= end) return; // warunek konca rekurencji


        Animal pivot = animals[end]; // ustawienie pivota jako ostatni element
        int insertPoint = start; // ustawienie poczatkowego punktu wstawienia

        // petla przeszukująca tablice od poczatku do konca
        for (int i = start; i < end; i++) {
            if (animals[i].getName().compareTo(pivot.getName()) <= 0) { // porownanie nazw zwierzat alfabetycznie
                swap(animals, insertPoint, i); // zamieniamy miejscami elementy
                insertPoint++; // przesuwamy insertPoint do przodu
            }
        }

        // po petli zamiena pivota na jego wlasciowa pozycje
        swap(animals, insertPoint, end);

        // wywolanie rekurencyjne dla lewej i prawej czesci tablicy
        quickSort(animals, start, insertPoint - 1); // sortuje lewa czesc
        quickSort(animals, insertPoint + 1, end); // sortuje prawa czesc
    }

    // Metoda do zamiany miejscem elementów
    private static void swap(Animal[] animals, int i, int j) {
        Animal temp = animals[i];
        animals[i] = animals[j];
        animals[j] = temp;
    }
}

package Sortowanie.QuickSort;

public class QuickSort {
    public static void main(String[] args) {
        int[] tab = {10, 40, 50, 20, 60, 30};
        for (int j : tab) {
            System.out.print(j + ", ");
        }

        // wywolanie quicksort
        quickSort(tab, 0, tab.length - 1);

        System.out.println("\nPo sortowaniu");

        for (int j : tab) {
            System.out.print(j + ", ");
        }
    }

    // Metoda do sortowania tablicy za pomoca QuickSort
    private static void quickSort(int[] tab, int start, int end) {
        if (start >= end) return; // warunek konca rekurencji


        int pivot = tab[end]; // ustawienie pivota jako ostatni element
        int insertPoint = start; // ustawienie poczatkowego punktu wstawienia

        // petla przeszukująca tablice od poczatku do konca
        for (int i = start; i < end; i++) {
            if (tab[i] <= pivot) { // jesli biezacy  element jest mniejszy lub rowny pivotowi
                swap(tab, insertPoint, i); // zamieniamy miejscami elementy
                insertPoint++; // przesuwamy insertPoint do przodu
            }
        }

        // po petli zamiena pivota na jego wlasciowa pozycje
        swap(tab, insertPoint, end);

        // wywolanie rekurencyjne dla lewej i prawej czesci tablicy
        quickSort(tab, start, insertPoint - 1); // sortuje lewa czesc
        quickSort(tab, insertPoint + 1, end); // sortuje prawa czesc
    }

    // Metoda do zamiany miejscem elementów
    private static void swap(int[] tab, int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }
}
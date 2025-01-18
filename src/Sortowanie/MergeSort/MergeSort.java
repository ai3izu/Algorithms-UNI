package Sortowanie.MergeSort;

public class MergeSort {
    public static void main(String[] args) {
        int[] tab = {10, 40, 50, 20, 60, 30};
        for (int j : tab) {
            System.out.print(j + ", ");
        }

        // wywolanie mergesort
        mergeSort(tab, 0, tab.length - 1);

        System.out.println("\nPo sortowaniu");
        for (int j : tab) {
            System.out.print(j + ", ");
        }

    }

    // Metoda do sortowania tablicy za pomoca MergeSort
    private static void mergeSort(int[] tab, int left, int right) {
        if (left >= right) return; // warunek konca rekurencji
        int mid = (left + right) / 2; // srodkowy indeks tablicy

        mergeSort(tab, left, mid); // rekurencyjne wywolanie dla lewej czesci talbicy
        mergeSort(tab, mid + 1, right); // rekurencyjne wywolanie dla prawej czesci talbicy


        int leftSize = mid - left + 1; // rozmiar lewej czesci
        int rightSize = right - mid; // rozmiar prawej czesci

        // tablice pomocnicze do przechowywania lewej i prawej czesci
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // skopiowanie danych do tablicy pomocniczej
        System.arraycopy(tab, left, leftArray, 0, leftSize);
        System.arraycopy(tab, mid + 1, rightArray, 0, rightSize);

        // indeksy do przeszukiwania lewej i prawej tablicy oraz zapisu do tablicy glownej
        int leftIndex = 0, rightIndex = 0, mainIndex = left;

        // laczenie lewej i prawej tablicy
        while (leftIndex < leftSize && rightIndex < rightSize) {
            // porownywanie elementow lewej i prawej tablicy
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                // wstawienie mniejszego elementu z lewej tablicy do glownej tablicy
                tab[mainIndex] = leftArray[leftIndex];
                leftIndex++; // inkrementacja indeksu lewej tablicy
            } else {
                // wstawienie mniejszego elementu z prawej tablicy do glownej tablicy
                tab[mainIndex] = rightArray[rightIndex];
                rightIndex++; // inkrementacja indeksu prawej tablicy
            }
            mainIndex++; // inkrementacja indeksu glownej tablicy
        }

        // wstawianie pozostalych elementow z lewej tablicy
        while (leftIndex < leftSize) {
            tab[mainIndex] = leftArray[leftIndex];
            leftIndex++;
            mainIndex++;
        }

        // wstawianie pozostalych elementow z prawej tablicy
        while (rightIndex < rightSize) {
            tab[mainIndex] = rightArray[rightIndex];
            rightIndex++;
            mainIndex++;
        }
    }
}

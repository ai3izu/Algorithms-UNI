package Sortowanie.MergeSort;

public class MergeSortObj {
    public static void main(String[] args) {
        Car[] cars = {
                new Car("BMW", 500),
                new Car("Audi", 200),
                new Car("Mercedes", 100),
                new Car("Opel", 4200),
                new Car("Fiat", 520),
                new Car("Volkswagen", 50)
        };
        for (Car car : cars) {
            System.out.print(car + ", ");
        }

        // wywolanie mergesort
        mergeSort(cars, 0, cars.length - 1);

        System.out.println("\nPo sortowaniu");
        for (Car car : cars) {
            System.out.print(car + ", ");
        }

    }

    // Metoda do sortowania tablicy za pomoca MergeSort
    private static void mergeSort(Car[] cars, int left, int right) {
        if (left >= right) return; // warunek konca rekurencji
        int mid = (left + right) / 2; // srodkowy indeks tablicy

        mergeSort(cars, left, mid); // rekurencyjne wywolanie dla lewej czesci talbicy
        mergeSort(cars, mid + 1, right); // rekurencyjne wywolanie dla prawej czesci talbicy


        int leftSize = mid - left + 1; // rozmiar lewej czesci
        int rightSize = right - mid; // rozmiar prawej czesci

        // tablice pomocnicze do przechowywania lewej i prawej czesci
        Car[] leftArray = new Car[leftSize];
        Car[] rightArray = new Car[rightSize];

        // skopiowanie danych do tablicy pomocniczej
        System.arraycopy(cars, left, leftArray, 0, leftSize);
        System.arraycopy(cars, mid + 1, rightArray, 0, rightSize);

        // indeksy do przeszukiwania lewej i prawej tablicy oraz zapisu do tablicy glownej
        int leftIndex = 0, rightIndex = 0, mainIndex = left;

        // laczenie lewej i prawej tablicy
        while (leftIndex < leftSize && rightIndex < rightSize) {
            // porownywanie elementow lewej i prawej tablicy
            if (leftArray[leftIndex].getPrice() <= rightArray[rightIndex].getPrice()) {
                // wstawienie mniejszego elementu z lewej tablicy do glownej tablicy
                cars[mainIndex] = leftArray[leftIndex];
                leftIndex++; // inkrementacja indeksu lewej tablicy
            } else {
                // wstawienie mniejszego elementu z prawej tablicy do glownej tablicy
                cars[mainIndex] = rightArray[rightIndex];
                rightIndex++; // inkrementacja indeksu prawej tablicy
            }
            mainIndex++; // inkrementacja indeksu glownej tablicy
        }

        // wstawianie pozostalych elementow z lewej tablicy
        while (leftIndex < leftSize) {
            cars[mainIndex] = leftArray[leftIndex];
            leftIndex++;
            mainIndex++;
        }

        // wstawianie pozostalych elementow z prawej tablicy
        while (rightIndex < rightSize) {
            cars[mainIndex] = rightArray[rightIndex];
            rightIndex++;
            mainIndex++;
        }
    }
}

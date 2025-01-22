package Sortowanie.MergeSort;

public class Car {
    private final String brand;
    private final int price;

    public Car(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", price=" + price + '}';
    }

}

package solution.carExample;

public class Car {
    private String make;
    private String model;
    private double price;

    public Car(String make, String model, double price) {
        this.make = make;
        this.model = model;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Car: " + make + ", " + model + ", " + price;
    }
}

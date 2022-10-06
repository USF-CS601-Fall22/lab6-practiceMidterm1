package solution.carExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Solution to the CarDealer problem */
public class CarDealer {
    // Declare a map
    private Map<String, Map<String, List<Car>>> carMap;

    public CarDealer() {
        // initialize the map
        carMap = new HashMap<>();

    }

    public void add(String make, String model, double price) {
        // Create a car with the given parameters and add it to the map
        if (!carMap.containsKey(make))
            carMap.put(make, new HashMap<>());

        Map<String, List<Car>> modelMap = carMap.get(make);
        if (!modelMap.containsKey(model))
            modelMap.put(model, new ArrayList<>());

        List<Car> carList = modelMap.get(model);
        carList.add(new Car(make, model, price));


        // With putIfAbsent, it would be even easier:
        /* carMap.putIfAbsent(make, new HashMap<>());
        carMap.get(make).putIfAbsent(model, new ArrayList<>());
        carMap.get(make).get(model).add(new Car(make, model, price));
         */
    }

    public double getAveragePrice(String make) {
        if (!carMap.containsKey(make)) {
            System.out.println("This make does not exist in the map.");
            throw new IllegalArgumentException();
        }
        Map<String, List<Car>> modelMap = carMap.get(make);
        double avgPrice = 0;
        int numCars = 0;
        // Return an average price for all the cars of a given "make";
        for (String model: modelMap.keySet()) {
            if (modelMap.containsKey(model)) {
                List<Car> carList = modelMap.get(model);
                for (Car car: carList) {
                    avgPrice += car.getPrice();
                    numCars++;
                }
            }
        }
        if (numCars == 0) {
            System.out.println("No cars of this type");
            return 0;
        }

        return avgPrice/numCars;
    }

    public String toString() {
        return "Cars: " + carMap;
    }

    public static void main(String[] args) {
        CarDealer dealer = new CarDealer();
        dealer.add("Toyota", "Corolla", 20000);
        dealer.add("Toyota", "Corolla", 15000);
        dealer.add("Toyota", "Camry", 23000);
        dealer.add("Toyota", "Camry", 25000);
        dealer.add("Toyota", "Camry", 27000);

        dealer.add("Honda", "Civic", 15000);
        dealer.add("Honda", "Civic", 17000);
        dealer.add("Honda", "Accord", 22000);
        dealer.add("Honda", "Accord", 25000);
        System.out.println(dealer);
        System.out.println(dealer.getAveragePrice("Toyota"));



    }

}

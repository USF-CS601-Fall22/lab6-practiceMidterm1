package solution.carExample;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/** Solution to the CarExample problem */
public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car("Ford", "Fusion", 22300);
        Car car2 = new Car("Honda", "Civic", 14100);
        Car car3 = new Car("Mazda", "6", 15000);
        Car car4 = new Car("Mazda", "3", 14000);
        Car car5 = new Car("Mazda", "3", 14600);
        Car car6 = new Car("Ford", "Escape", 19700);
        Car car7 = new Car("Honda", "Civic", 13800);

        // Create a TreeSet of cars, passing the comparator.
        SortedSet<Car> carSet = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                if (Math.abs(car1.getPrice() - car2.getPrice()) < 0.01)
                    return  0;
                else
                    return Double.compare(car1.getPrice(), car2.getPrice());
            }
        });

        // Add car1, car2, car3 to carSet
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        carSet.add(car4);
        carSet.add(car5);
        carSet.add(car6);
        carSet.add(car7);

        // Iterate over the TreeSet of cars and print info about
        // each car
        Iterator<Car> it = carSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}

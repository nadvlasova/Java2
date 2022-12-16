package lesson4.Garage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();

        Bike bike = new Bike("Java", 10);
        Car car = new Car("BMW", 100);

        vehicleArrayList.add(bike);
        vehicleArrayList.add(car);
        System.out.println(vehicleArrayList);

        ArrayList<Vehicle> vehicleArrayList1 = new ArrayList<>(List.of(new Bike("Hitachi",12),
                new Car("Lada", 180)));

        Collections.sort(vehicleArrayList1);
        System.out.println(vehicleArrayList1);
        Collections.reverse(vehicleArrayList1);
        System.out.println(vehicleArrayList1);

    }
}

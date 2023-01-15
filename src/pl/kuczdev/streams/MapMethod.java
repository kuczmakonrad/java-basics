package pl.kuczdev.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapMethod {
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("Dogde", 250, 300000, 4));
        carList.add(new Car("Citroen", 180, 200000, 3));
        carList.add(new Car("Opel", 220, 150000, 4));
        carList.add(new Car("Merc", 250, 400000, 5));
        carList.add(new Car("GMC", 170, 100000, 3));
        carList.add(new Car("Porsche", 300, 800000, 5));
        carList.add(new Car("BMW", 240, 300000, 5));

        List<Integer> carListPrice = carList.stream().filter(car -> car.price > 200000).map(Car::getPrice).collect(Collectors.toList());
        System.out.println(carListPrice);
    }
}

package pl.kuczdev.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class IterateMethod {
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("Dogde", 250, 300000, 4));
        carList.add(new Car("Citroen", 180, 200000, 3));
        carList.add(new Car("Opel", 220, 150000, 4));
        carList.add(new Car("Merc", 250, 400000, 4));
        carList.add(new Car("GMC", 170, 100000, 3));
        carList.add(new Car("Porsche", 300, 800000, 4));
        carList.add(new Car("BMW", 240, 300000, 5));

        Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(s -> System.out.println(s));       // OUTPUT: 1,2,3,4,5,6,7,8,9,10

        System.out.println("---");

        Stream.iterate(1, n -> n < 10, n -> n + 2)
                .forEach(s -> System.out.println(s));       // OUTPUT: 1,3,5,7,9
    }
}

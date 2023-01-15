package pl.kuczdev.streams;

import java.util.ArrayList;

public class CountMethod {
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("Dogde", 250, 300000, 4));
        carList.add(new Car("Citroen", 180, 200000, 3));
        carList.add(new Car("Opel", 220, 150000, 4));
        carList.add(new Car("Merc", 250, 400000, 4));
        carList.add(new Car("GMC", 170, 100000, 3));
        carList.add(new Car("Porsche", 300, 800000, 4));
        carList.add(new Car("BMW", 240, 300000, 5));

        long howManyCarsAbove500k = carList.stream().filter(car -> car.price < 500000).count();
        System.out.println("Above 500k in list we got: " + howManyCarsAbove500k + " cars!");        // OUTPUT: Above 500k in list we got: 6 cars!
    }
}

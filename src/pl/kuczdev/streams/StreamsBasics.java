package pl.kuczdev.streams;

import java.util.ArrayList;

public class StreamsBasics {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Asia");
        arr.add("Paweł");
        arr.add("Daniel");
        arr.add("Ola");
        arr.add("Zuzanna");
        arr.add("Zenon");

        // moglibyśmy użyć pętli for-each, ale po co skoro możemy skorzystać ze streama
        //
        arr.stream()
                .filter(str -> str.length() > 3 && str.length() < 7)
                .filter(str -> str.startsWith("A") || str.startsWith("P"))
                .forEach(str -> System.out.println(str));

        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("Dogde", 250, 300000, 4));
        carList.add(new Car("Citroen", 180, 200000, 3));
        carList.add(new Car("Opel", 220, 150000, 4));
        carList.add(new Car("Merc", 250, 400000, 5));
        carList.add(new Car("GMC", 170, 100000, 3));
        carList.add(new Car("Porsche", 300, 800000, 5));
        carList.add(new Car("BMW", 240, 300000, 5));

        carList.stream()
                .filter(car -> car.rating > 3)
                .filter(car -> car.price > 250000 && car.price < 10000000)
                .filter(car -> car.topSpeed > 240 && car.topSpeed < 360)
                .filter(car -> car.name.startsWith("M") || car.name.startsWith("P") || car.name.startsWith("d"))
                .forEach(car -> System.out.println(car));
    }
}

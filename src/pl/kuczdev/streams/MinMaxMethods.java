package pl.kuczdev.streams;

import java.util.ArrayList;

public class MinMaxMethods {
    public static void main(String[] args) {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("Dogde", 250, 300000, 4));
        carList.add(new Car("Citroen", 180, 200000, 3));
        carList.add(new Car("Opel", 220, 150000, 4));
        carList.add(new Car("Merc", 250, 400000, 4));
        carList.add(new Car("GMC", 170, 100000, 3));
        carList.add(new Car("Porsche", 300, 800000, 4));
        carList.add(new Car("BMW", 240, 300000, 5));

        Car maxPriceCarByMaxMethod = carList.stream().max(
                (car1, car2) -> (car1.price > car2.price) ? 1 : -1)
                .get();

        System.out.println("Max price car (by method max) = " + maxPriceCarByMaxMethod);    // OUTPUT: Max price car (by method min) = Car{name='Porsche', topSpeed=300, price=800000, rating=4}

        Car maxPriceCarByMinMethod = carList.stream().min(
                (car1, car2) -> (car1.price < car2.price) ? 1 : -1)
                .get();

        System.out.println("Max price car (by method min) = " + maxPriceCarByMinMethod);    // OUTPUT: Max price car (by method min) = Car{name='Porsche', topSpeed=300, price=800000, rating=4}


        System.out.println("---");


        Car minPriceCarByMinMethod = carList.stream().min(
                (car1, car2) -> (car1.price > car2.price) ? 1 : -1)
                .get();

        System.out.println("Min price car (by method min) = " + minPriceCarByMinMethod);    // OUTPUT: Min price car (by method max) = Car{name='GMC', topSpeed=170, price=100000, rating=3}

        Car minPriceCarByMaxMethod = carList.stream().max(
                        (car1, car2) -> (car1.price < car2.price) ? 1 : -1)
                .get();

        System.out.println("Min price car (by method max) = " + minPriceCarByMaxMethod);    // OUTPUT: Min price car (by method max) = Car{name='GMC', topSpeed=170, price=100000, rating=3}


        System.out.println("---");


        Car maxRatingByMaxMethod = carList.stream().max(
                (car1,car2) -> (car1.rating > car2.rating) ? 1 : -1)
                .get();

        System.out.println("Max rating car (by method max) = " + maxRatingByMaxMethod);     // OUTPUT: Max rating car (by method max) = Car{name='BMW', topSpeed=240, price=300000, rating=5}

        Car maxRatingByMinMethod = carList.stream().min(
                (car1,car2) -> car1.rating < car2.rating ? 1 : -1)
                .get();

        System.out.println("Max rating car (by method min) = " + maxRatingByMinMethod);     // OUTPUT: Max rating car (by method max) = Car{name='BMW', topSpeed=240, price=300000, rating=5}
    }
}
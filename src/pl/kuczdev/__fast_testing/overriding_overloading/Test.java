package pl.kuczdev.__fast_testing.overriding_overloading;

class Car {
    public static void startEngine(){
        System.out.println("Car Engine Started");
    }
}

class Porsche extends Car {
    public static void startEngine() {
        System.out.println("Porche's Engine Started");
    }
}

public class Test {
    public static void main(String args[]){
        Car car1 = new Porsche();
        Car car2 = new Car();
        car1.startEngine();
        car2.startEngine();
    }
}


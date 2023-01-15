package pl.kuczdev.oop_basics.test;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("Car");
        Vehicle vehicle = new Vehicle("Vehicle");
        Car vehicleCar = (Car) vehicle;
        if (car instanceof Vehicle) {
            System.out.println("car instanceof Vehicle");
        }

        if (vehicle instanceof Car) {
            System.out.println("vehicle instanceof Car");
        }

        if (vehicleCar instanceof Vehicle) {
            System.out.println("vehicleCar instanceof Vehicle");
        }
    }
}

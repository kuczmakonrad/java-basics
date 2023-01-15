package pl.kuczdev.design_patterns.builder;

public class BuilderExample {
    public static void main(String[] args) {
        Car car = new Car
                    .CarBuilder("Ford", "Mustang")
                    .withColor("Red")
                    .withTopSpeed(250)
                    .build();

        System.out.println(car);

        Car car2 = new Car
                    .CarBuilder("VW", "Golf")
                    .build();

        System.out.println(car2);
    }
}

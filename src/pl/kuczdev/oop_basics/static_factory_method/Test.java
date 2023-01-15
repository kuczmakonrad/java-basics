package pl.kuczdev.oop_basics.static_factory_method;

public class Test {
    public static void main(String[] args) {
        Coordinate coordFromPolar = Coordinate.fromPolar(3 * Math.sqrt(2), 45);
        Coordinate coordFromXY = Coordinate.fromXY(3, 3);

        boolean result = coordFromPolar.equals(coordFromXY);
        System.out.println(result); //true
    }
}

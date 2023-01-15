package pl.kuczdev.devcaveblog.a01_static_factory_method;
/*
Jednym z plusów użycia static Factory Method jest to, że można zrobić kilka metod z parametrami o tym samym typie.
W przypadku konstruktorów nie jest to możliwe, a w przypadku static factory method istnieje taka możliwość.

Weźmy na przykład taką implementację klasy Coordinate, którą chcemy tworzyć na dwa sposoby:
W poniższym przypadku, gdy tworzymy obiekt za pośrednictwem konstruktorów nie mamy możliwości zadeklarowania dwóch konstruktorów z taką samą sygnaturą (czyli ilością i typem parametrów).
Tu z pomocą przychodzi nam nasza statyczna fabryka: p03_CoordinateByStaticFactoryMethod.java
*/
public class p02_CoordinateByConstructor { }

class Coordinate {
    private double x;
    private double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }
/*
    public CoordinateByConstructor(double dist, double angle) {
        angle = Math.toRadians(angle);
        this.x = Math.round(dist * Math.cos(angle));
        this.y = Math.round(dist * Math.sin(angle));
    }
*/
}

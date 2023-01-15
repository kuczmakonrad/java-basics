package pl.kuczdev.oop_basics.static_factory_method;

public class Coordinate {
    private double x;
    private double y;

    private Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate fromXY(double x, double y) {
        return new Coordinate(x, y);
    }

    public static Coordinate fromPolar(double dist, double angle) {
        angle = Math.toRadians(angle);
        return new Coordinate(Math.round(dist * Math.cos(angle)), Math.round(dist * Math.sin(angle)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }
}

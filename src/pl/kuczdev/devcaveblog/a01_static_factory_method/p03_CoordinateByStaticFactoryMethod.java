package pl.kuczdev.devcaveblog.a01_static_factory_method;
/*
Tu dodatkowo zadeklarowałem konstruktor jako private.
Jest to opcjonalne - mogliśmy równie dobrze zostawić publiczny konstruktor i zrezygnować z fabryki Coordinate fromXY(double x, double y).

W ten sposób możemy utworzyć obiekt na dwa sposoby, podając argumenty o tym samym typie, ale o innym znaczeniu:
Widać też, że nazwy jasno określają intencję, czego nie możemy osiągnąć używając konstruktorów.
*/

public class p03_CoordinateByStaticFactoryMethod {
    public static void main(String[] args) {
        Coordinatee coordFromPolar = Coordinatee.fromPolar(3 * Math.sqrt(2), 45);
        Coordinatee coordFromXY = Coordinatee.fromXY(3, 3);

        System.out.println("coordFromPolar  ->  " + coordFromPolar);
        System.out.println("coordFromXY  ->  " + coordFromXY);
        System.out.println(coordFromPolar.equals(coordFromXY)); //true
    }
}

class Coordinatee {
    private double x;
    private double y;

    private Coordinatee(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinatee fromXY(double x, double y) {
        return new Coordinatee(x, y);
    }

    public static Coordinatee fromPolar(double dist, double angle)  {
        angle = Math.toRadians(angle);
        return new Coordinatee(Math.round(dist * Math.cos(angle)), Math.round(dist * Math.sin(angle)));
    }

    @Override
    public String toString() {
        return "Coordinatee{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinatee that = (Coordinatee) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }
}

package pl.kuczdev.generics;

import java.util.ArrayList;
import java.util.List;

class Point<T> {
    private T x;
    private T y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Trio <T, U, V> {
    private T first;
    private U second;
    private V third;

    public Trio(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public V getThird() {
        return third;
    }

    public void setThird(V third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "Trio{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}

public class SimpleGenerics {
    public static void main(String[] args) {
        Point<Integer> pointInteger = new Point<>(230, 350);
        System.out.println(pointInteger.toString());

        Point<String> pointString = new Point<>("Twenty two (22)", "Eight (8)");
        System.out.println(pointString.toString());

        List<String> strArray = new ArrayList<>();

        Trio <String, Integer, String> trio = new Trio<>("Pierwszy String", 1004, "Kolejny String");
        System.out.println(trio.toString());

    }
}

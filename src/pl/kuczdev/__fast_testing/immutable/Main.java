package pl.kuczdev.__fast_testing.immutable;

public class Main {
    public static void main(String[] args) {
        Number result = Number.of(1).add(Number.of(10));
        System.out.println("Result: " + result.getNumber());
    }
}

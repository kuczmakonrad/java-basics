package pl.kuczdev.__fast_testing.immutable;

// korzystając z wzorca immutable object, zaimplementuj klasę Number reprezentującą liczbę całkowitą.
// Klasa powinna implementować przynajmniej dwie metody: Number of(int n) tworzącą nowy obiekt oraz Number add(Number number) dodającą dwa obiekty.

public final class Number {
    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        return new Number(number);
    }

    public int getNumber() {
        return number;
    }

    public Number add(Number num) {
        return new Number(number + num.number);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

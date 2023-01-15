package pl.kuczdev.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("BMW");
        arr.add("Mercedes");
        arr.add(null);
        arr.add("Toyota");


        arr.removeIf(e -> e == null || e.equals("Toyota"));
        System.out.println(arr);
    }
}

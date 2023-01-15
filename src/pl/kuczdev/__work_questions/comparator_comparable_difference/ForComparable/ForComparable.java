package pl.kuczdev.__work_questions.comparator_comparable_difference.ForComparable;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
We will create class country having attribute id and name.
This class will implement Comparable interface and implement CompareTo method to sort collection of country object by id.
*/

public class ForComparable {
    public static void main(String[] args) {
        Country c1 = new Country(1,"USA");
        Country c2 = new Country(2,"Germany");
        Country c3 = new Country(3,"Poland");
        Country c4 = new Country(4,"Brasil");

        List<Country> list = new ArrayList<>();
        list.add(c4);
        list.add(c3);
        list.add(c2);
        list.add(c1);

        System.out.println("Before sort:");
        for (Country c: list) {
            System.out.println(c.id + ". " + c.name);
        }

        Collections.sort(list);
        System.out.println("After sort:");
        for (Country c: list) {
            System.out.println(c.id + ". " + c.name);
        }
    }
}

package pl.kuczdev.__work_questions.comparator_comparable_difference.ForComparator;
/*
We will create class country having attribute id and name and will create another class CountrySortByIdComparator
which will implement Comparator interface and implement compare method to sort collection of country object by id
and we will also see how to use anonymous comparator.
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ForComparator {
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
            System.out.println(c.countryId + ". " + c.countryName);
        }

        CountrySortbyIdComparator comparator = new CountrySortbyIdComparator();
        Collections.sort(list, comparator);

        System.out.println("After sort:");
        for (Country c: list) {
            System.out.println(c.countryId + ". " + c.countryName);
        }


        System.out.println("After Sort by countryName");
        Collections.sort(list, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.countryName.compareTo(o2.countryName);
            }
        });

        for (Country c: list) {
            System.out.println(c.countryId + ". " + c.countryName);
        }
    }
}

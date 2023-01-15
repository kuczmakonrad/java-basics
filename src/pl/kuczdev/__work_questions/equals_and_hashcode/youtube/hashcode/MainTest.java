package pl.kuczdev.__work_questions.equals_and_hashcode.youtube.hashcode;

import java.util.HashMap;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {
        /*
        Cat susie = new Cat("Susie", 3);
        Cat lester = new Cat("Lester", 5);
        Cat lili = new Cat("Lili", 1);

        Map<Cat, String> catOwnerMap = new HashMap<>();
        catOwnerMap.put(susie, "Adam");
        catOwnerMap.put(lester, "Michał");
        catOwnerMap.put(lili, "Kamil");

        System.out.println("Object susie hashcode = " + susie.hashCode());
        System.out.println("Object lester hashcode = " + lester.hashCode());
        System.out.println("Object lili hashcode = " + lili.hashCode());

        System.out.println("Get Susie Owner from Map = " + catOwnerMap.get(susie));
        */


        Cat cat1 = new Cat("Susie", 3);
        Cat cat2 = new Cat("Susie", 3);

        System.out.println("cat1.equals(cat2) = " + cat1.equals(cat2));

        Map<Cat, String> catMap = new HashMap<>();
        catMap.put(cat1, "Kasia");
        catMap.put(cat2, "Grażyna");

        System.out.println(catMap.get(cat1));
        System.out.println(catMap.get(cat2));

    }
}

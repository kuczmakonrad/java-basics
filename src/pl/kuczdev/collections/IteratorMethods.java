package pl.kuczdev.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorMethods {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Dogde");
        arr.add("Volvo");
        arr.add("Pontiac");

        System.out.println("Użycie metody forEachRemaining (z wyrażeniem lambda):");
        arr.iterator().forEachRemaining(element ->  {
            System.out.println(element);
        });

        Iterator<String> iterator = arr.iterator();
        while(iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals("Pontiac")) {
                iterator.remove();      // MOŻEMY WYKONAC TYLKO I WYŁĄCZNIE GDY WCZEŚNIEJ WYWOŁAMY METODĘ NEXT()
            }
        }

        System.out.println("Lista po usunięciu pontiaca: \n" + arr);
    }
}

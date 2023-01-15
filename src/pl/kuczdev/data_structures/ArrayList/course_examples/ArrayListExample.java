package pl.kuczdev.data_structures.ArrayList.course_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        System.out.println("--------- 1. ---------");   // dodawanie do listy - przyjmuje nulle i duplikaty
        list.add("Kamil");
        list.add("Konrad");
        list.add("Konrad");
        list.add("Emil");
        list.add(null);
        list.add(null);
        System.out.println("Ile elementów w liście? " + list.size());

        System.out.println("--------- 2. ---------");   // wyświetlenie listy toString
        System.out.println("Lista: " + list);

        for (String s: list) {                          // wyświetlanie listy forEach
            System.out.println(s);
        }

        System.out.println("--------- 3. ---------");
        list.remove(null);          // usunięcie wartosci, które były podwójne - usuwamy po wartości pierwszą napotkaną wartość w liście (jeżeli są podwojne)
        list.remove("Konrad");      // usunięcie wartosci, które były podwójne - usuwamy po wartości pierwszą napotkaną wartość w liście (jeżeli są podwojne)
        System.out.println(list);

        System.out.println("--------- 4. ---------");       // pobranie pierwszego/ostatniego elementu listy metodą get(), po indeksie.
        System.out.println("Pierwszy element listy: " + list.get(0));
        System.out.println("Ostatni element listy: " + list.get(list.size()-1));

        System.out.println("--------- 5. ---------");       // dodanie innej listy do listy metodą .addAll()
        System.out.println("Lista przed dodaniem innej listy: " + list);
        List<String> classNames = new ArrayList<String>(Arrays.asList("Kasia", "Basia", "Asia"));
        list.addAll(classNames);
        System.out.println("Lista po dodaniu innej listy: " + list);

        System.out.println("--------- 6. ---------");       // wyczyszczenie listy i sprawdzenie czy jest pusta (przed i po wyczyszczeniu)
        System.out.println("Lista przed wyczyszczeniem: " + list);
        System.out.println("Czy lista jest pusta przed wyczyszczeniem? " + list.isEmpty());
        list.clear();
        System.out.println("Lista po wyczyszczeniu: " + list);
        System.out.println("Czy lista jest pusta po wyczyszczeniu? " + list.isEmpty());

        System.out.println("-------- 7. ---------");       // czy lista zawiera wskazaną wartość - czy lista zawiera inną listę
        list.add("Konrad");
        System.out.println("Czy lista zawiera wartość Konrad? " + list.contains("Konrad"));
        System.out.println("Czy lista \'lista\' zawiera listę \'classNames\'? " + list.containsAll(classNames));
    }
}

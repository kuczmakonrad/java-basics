package pl.kuczdev.__work_questions.data_structures.ArrayList.course_examples;

import java.util.ArrayList;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class ArrayListMethods {
    public static void main(String[] args) {
        // tworze cztery obiekty typu Person
        Person p1 = new Person("Kamil");
        Person p2 = new Person("Emil");
        Person p3 = new Person("Milena");
        Person p4 = new Person("Kasia");

        // tworze Arrayliste typu Person
        ArrayList <Person> personList = new ArrayList<>();

        // dodaje cztery obiekty do listy
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        // wyświetlam i sprawdzam czy wszystko działa pętlą for-each
        for (Person p: personList) {
            System.out.println(p);
        }


        // tworze dwa dodatkowe obiekty typu person
        Person p5 = new Person("Bartek");
        Person p6 = new Person("Marek");

        // tworze drugą listę typu Person
        ArrayList <Person> additionalPersonList = new ArrayList<>();

        // list.add(...) - dodaje dwa dodatkowe obiekty do drugiej listy
        additionalPersonList.add(p5);
        additionalPersonList.add(p6);

        // list1.addAll(list2) - dodaję drugą dodatkową listę do pierwszej listy
        personList.addAll(additionalPersonList);

        System.out.println("\nPo dodaniu dodatkowej listy: ");
        for (Person p : personList) {
            System.out.println(p);
        }

        // list.contains(...) czy kolekcja posiada dany element
        if (personList.contains(p4)) {
            System.out.println("\nW liscie znajduje się p4");
        }

        // czy pierwsza lista zawiera dodatkową listę? (tak zawiera, bo ją dodałem wcześniej metodą addAll)
        if (personList.containsAll(additionalPersonList)) {
            System.out.println("\nW liscie znajduje się dodatkowa lista");
        }

        // dodaję nowego Persona do dodatkowej listy, żeby sprawdzić ponownie warunek
        Person p7 = new Person("Dodatkowy Mietek");
        additionalPersonList.add(p7);

        // Teraz pierwsza lista nie zawiera dodatkowej listy (bo dodałem do niej nowego Persona i nie przeniosłem go do pierwotnej listy)
        if (personList.containsAll(additionalPersonList)) {
            System.out.println("\nW liscie znajduje się dodatkowa lista");
        } else {
            System.out.println("\nW liście nie znajduje się dodatkowa lista - do dodatkowej listy musiał zostać dodany nowy Person");
        }

        // Usuwam dodatkowego persona z dodatkowej listy
        additionalPersonList.remove(p7);

        // Teraz ponownie będzie true, bo usunięto dodatkowego persona
        if (personList.containsAll(additionalPersonList)) {
            System.out.println("\nTRUEEE");
        } else {
            System.out.println("\nFALSEEE");
        }


        // usuwam dodatkową listę z pierwotnej listy
        personList.removeAll(additionalPersonList);

        System.out.println("\nPo usunięciu dodatkowej listy z pierwotnej listy: ");
        for (Person p : personList) {
            System.out.println(p);
        }

        System.out.println("Mamy jeszcze metodę dobrze nam znaną personList.size() = " + personList.size());
        Person people[] = new Person[personList.size()];
        people = personList.toArray(people);
        System.out.println("Dlugosc tabeli = " + people.length);

        // czyszczenie listy (dodatkowo użyta metoda isEmpty)
        personList.clear();

        if(personList.isEmpty()) {
            System.out.println("Kolekcja pusta");
        }
    }
}

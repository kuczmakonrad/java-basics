package pl.kuczdev.__work_questions.data_structures.LinkedList.course_examples;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListBasics {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Adam");
        String s1 = "Ola";
        list.add(s1);
        list.addFirst("Rafał");
        list.addLast("Olek");

        System.out.println(list);       // OUTPUT: [Rafał,Adam,Ola,Olek]

        System.out.println(list.getFirst());  // OUTPUT: Rafał
        System.out.println(list.getLast());   // OUTPUT: Olek

        list.removeFirst();
        list.removeLast();

        System.out.println(list);       // OUTPUT: [Adam,Ola]

        System.out.println(list.contains(s1));  // OUTPUT: True

        list.add("Daniel");
        list.add("Kuba");
        list.add(s1);
        list.add("Ania");

        System.out.println(list);       // OUTPUT: [Adam, Ola, Daniel, Kuba, Ola, Ania]

        list.removeFirstOccurrence(s1);         // OUTPUT: [Adam, Daniel, Kuba, Ola, Ania] - list.removeFirstOccurrence(value) - usuwa pierwszy wskazany napotkany obiekt z listy
        list.removeLastOccurrence("Ania");   // OUTPUT: [Adam, Daniel, Kuba, Ola] - list.removeLastOccurrence(value) - usuwa ostatni wskazany napotkany obiekt

        list.add(2, "Zenon");      // OUTPUT: [Adam, Daniel, Zenon, Kuba, Ola] - list.add(index, value) - dodaje pod konkretnym indexem
        System.out.println(list);

        list.set(0, "Katarzyna");
        System.out.println(list.size());

        ListIterator<String> iterator1 = list.listIterator();
        while(iterator1.hasNext()) {
            String str = iterator1.next();
            System.out.println(str);
        }
        //OUTPUT: Katarzyna,Daniel,Zenon,Kuba,Ola
        System.out.println("\n");

        ListIterator<String> iterator2 = list.listIterator(list.size());
        while(iterator1.hasPrevious()) {
            String str = iterator1.previous();
            System.out.println(str);
        }
        //OUTPUT: Ola,Kuba,Zenon,Daniel,Katarzyna
    }
}

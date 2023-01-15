package pl.kuczdev.data_structures.LinkedList.course_examples;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListIteratorManipulation {
    public static void main(String[] args) {
        LinkedList <String> list = new LinkedList<>();
        list.add("Adam");
        String s1 = "Ola";
        list.add(s1);
        list.addFirst("Rafał");
        list.addLast("Olek");

        System.out.println(list);		// OUTPUT: [Rafał, Adam, Ola, Olek]

        // LIST ITERATOR
        ListIterator<String> iterator = list.listIterator();

        while(iterator.hasNext()){
            String str = iterator.next();
            if(str.equalsIgnoreCase("Ola")) {
                iterator.set("Zuza");                   // Zamieni Olę na Zuzę (ponieważ w momencie gdy iterator.next() zwraca Olę to wpadnie w tego ifa, a metoda set zamienia to co jest pod next())
            }

            if(str.equals("Adam")) {
                iterator.add("Karol");                  // Po Adamie doda Karola
            }

            if(str.equalsIgnoreCase("Rafał")) {     // Usunie Rafała
                iterator.remove();
            }
        }

        System.out.println(list);        // OUTPUT: [Adam, Karol, Zuza, Olek]

        // ITERATOR
        Iterator<String> iter = list.iterator();

        while(iter.hasNext()) {
            System.out.println(iter.next());
        }



    }
}

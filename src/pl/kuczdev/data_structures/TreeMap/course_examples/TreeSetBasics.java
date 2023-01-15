package pl.kuczdev.data_structures.TreeMap.course_examples;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetBasics {
    public static void main(String[] args) {
        TreeSet<Integer> treeSetInt = new TreeSet<>();
        treeSetInt.add(40);
        treeSetInt.add(4);
        treeSetInt.add(15);
        treeSetInt.add(333);
        treeSetInt.add(1);

        // ITERACJA ROSNĄCA (OD NAJMNIEJSZEJ LICZBY DO NAJWIĘKSZEJ)
        Iterator<Integer> iterator = treeSetInt.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // ITERACJA MALEJĄCA (OD NAJWIĘKSZEJ LICZBY DO NAJMNIEJSZEJ)
        Iterator<Integer> descendingIterator = treeSetInt.descendingIterator();

        while(descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }

    }
}

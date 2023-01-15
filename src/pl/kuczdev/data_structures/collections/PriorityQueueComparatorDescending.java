package pl.kuczdev.data_structures.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

class DescendingComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {
        if (x == y) {
            return 0;
        } else if (x < y) {
            return 1;
        } else {
            return 0;
        }
    }
}

public class PriorityQueueComparatorDescending {
    public static void main(String[] args) {
        PriorityQueue<Integer> test = new PriorityQueue<>(new DescendingComparator());
        test.add(1000);
        test.add(99);
        test.add(88);
        test.add(55);

        while(!test.isEmpty()) {        // METODĘ POOL - pobierającą pierwszy element z kolejki i usuwającą ją z kolejki POWINNIŚMY WYWOŁYWAĆ ZE SPRAWDZENIEM CZY KOLEJKA NIE JEST PUSTA
            System.out.println("Pobrano element: " + test.poll());
        }

    }
}

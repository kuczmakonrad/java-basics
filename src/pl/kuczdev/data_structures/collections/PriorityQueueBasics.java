package pl.kuczdev.data_structures.collections;

import java.util.PriorityQueue;

public class PriorityQueueBasics {
    public static void main(String[] args) {
        PriorityQueue<Integer> test = new PriorityQueue<>();
        test.add(10);
        test.add(99);
        test.add(1000);
        test.add(55);

        System.out.println(test);   // OUTPUT: [10,55,99,1000]

        while(!test.isEmpty()) {        // METODĘ POOL - pobierającą pierwszy element z kolejki i usuwającą ją z kolejki POWINNIŚMY WYWOŁYWAĆ ZE SPRAWDZENIEM CZY KOLEJKA NIE JEST PUSTA
            Integer i = test.poll();
            System.out.println("Pobrano element: " + i);
        }

        System.out.println(test);   // OUTPUT: []

        test.add(10000);
        test.add(11);
        test.add(77);

        System.out.println(test);   // OUTPUT: [11,77,10000]

        System.out.println("Peek = " + test.peek());    // 11
        System.out.println(test);       //OUTPUT: [11,77,10000] - jak widać metoda peek nie usuwa z kolejki

    }
}
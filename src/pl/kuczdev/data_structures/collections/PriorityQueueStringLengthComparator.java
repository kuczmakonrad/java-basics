package pl.kuczdev.data_structures.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if(s1.length() == s2.length()) {        // Jeśli taka sama liczba znaków to alfabetycznie
            return s1.compareTo(s2);
        }
        return s1.length() - s2.length();       // w przeciwnym wypadku za pomocą liczby znaków
    }
}

public class PriorityQueueStringLengthComparator {
    public static void main(String[] args) {
        PriorityQueue <String> test = new PriorityQueue<>(new StringLengthComparator());
        test.add("Daniel");
        test.add("Ola");
        test.add("Adam");
        test.add("Ada");
        test.add("Zuzanna");

        while(!test.isEmpty()) {
            System.out.println(test.poll());
        }
    }
}

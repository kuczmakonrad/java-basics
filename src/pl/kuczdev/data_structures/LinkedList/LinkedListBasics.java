package pl.kuczdev.data_structures.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

/*
    1. Java LinkedList class used doubly linked list to store the elements.
    2. LinkedList maintains insertion order.
    3. It is not synchronized.
    4. Manipulation is quite fast in LinkedList as no shifting is required.
    5. LinkedList can be Stack, Queue or LinkedList.
*/
public class LinkedListBasics {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        System.out.println("LinkedList:");

        Iterator<String> it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

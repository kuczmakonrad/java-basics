package pl.kuczdev.__code_questions.q49_linkedList_how_to_find_middle_element;


import java.util.LinkedList;

public class LinkedListMiddleElement {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);


        System.out.println(getMiddleElement(list));
    }

    private static Integer getMiddleElement(LinkedList<Integer> l) {
        if ((l.size()) % 2 == 0) {
            return l.get((l.size()/2)-1);
        } else {
            return l.get((l.size()/2));
        }
    }
}

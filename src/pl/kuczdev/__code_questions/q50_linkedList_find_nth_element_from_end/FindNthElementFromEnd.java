package pl.kuczdev.__code_questions.q50_linkedList_find_nth_element_from_end;

import java.util.LinkedList;

public class FindNthElementFromEnd {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);


        System.out.println("5 element od końca w liście to: " + findNthElementFromEnd(list,5));
    }

    private static Integer findNthElementFromEnd(LinkedList<Integer> l, int elementFromEnd) {
        return l.get(l.size() - elementFromEnd);
    }
}

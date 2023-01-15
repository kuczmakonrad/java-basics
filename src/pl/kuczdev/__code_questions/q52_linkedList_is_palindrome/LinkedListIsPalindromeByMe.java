package pl.kuczdev.__code_questions.q52_linkedList_is_palindrome;

import java.util.LinkedList;

public class LinkedListIsPalindromeByMe {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(2);
        list.add(1);
        list.add(1);
        System.out.println(isLinkedListPalindroneByMe(list));
    }

    private static boolean isLinkedListPalindroneByMe(LinkedList l) {
        int max = l.size() - 1;
        for (int i = 0; i < l.size(); i++) {
            if (!(l.get(i).equals(l.get(max)))) return false;
            max--;
        }
        return true;
    }
}

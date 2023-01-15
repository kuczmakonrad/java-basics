package pl.kuczdev.__code_questions.q51_linkedList_how_to_find_detect_loop_if_found_find_first_node;

import java.util.LinkedList;

/*
First approach that you may think may something look like:
    *Traverse through each node till end, tracking visited node using visited flag.
    *If you find node that is already visited, then there is a loop in LinkedList and if you reach till end while traversing then there is no loop in LinkedList

But problem with above approach is, in most cases you can not change data structure of LinkedList node, so you won’t be able to add visited flag to it.

Efficient approach:
Efficient approach for this problem would be Floyd’s cycle detection algorithm,so steps for this algo would be:
    1. Use two pointer fastPtr and slowPtr and initialize both to head of linkedlist
    2. Move fastPtr by two nodes and slowPtr by one node in each iteration.
    3. If fastPtr and slowPtr meet at some iteration , then there is a loop in linkedlist.
    4. If fastPtr reaches to the end of linkedlist without meeting slow pointer then there is no loop in linkedlist (i.e fastPtr->next or fastPtr->next->next become null)

ifLoopExists() - Above solution work with o(n) time complexity and o(1) space complexity.
*/
public class LinkedListDetectLoop {
    private Node head;

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;

        }
    }

    public void addToTheLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean ifLoopExists() {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListDetectLoop list = new LinkedListDetectLoop();
        // Creating a linked list
        Node loopNode = new Node(5);
        list.addToTheLast(loopNode);
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));

        list.printList();

        // Test if loop existed or not
        System.out.println("Loop existed-->" + list.ifLoopExists());


        // creating a loop
        list.addToTheLast(loopNode);
        // Test if loop existed or not
        System.out.println("Loop existed-->" + list.ifLoopExists());

    }
}


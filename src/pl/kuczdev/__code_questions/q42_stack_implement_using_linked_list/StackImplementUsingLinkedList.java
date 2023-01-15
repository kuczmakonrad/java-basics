package pl.kuczdev.__code_questions.q42_stack_implement_using_linked_list;
/*
There are two most important operations of Stack:

Push : We will push element to beginning of linked list to demonstrate push behavior of  stack.
Pop : We will remove first element of linked list to demonstrate pop behavior of Stack .
 */
public class StackImplementUsingLinkedList {
    private Node head; // the first node

    // nest class to define linkedlist node
    private class Node {
        int value;
        Node next;
    }

    public StackImplementUsingLinkedList() {
        head = null;
    }

    // Remove value from the beginning of the list for demonstrating behaviour of stack
    public int pop() throws LinkedListEmptyException {
        if (head == null) throw new LinkedListEmptyException();

        int value = head.value;
        head = head.next;
        return value;
    }

    // Add value to the beginning of the list for demonstrating behaviour of stack
    public void push(int value) {
        Node oldHead = head;
        head = new Node();
        head.value = value;
        head.next = oldHead;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        StackImplementUsingLinkedList lls = new StackImplementUsingLinkedList();
        lls.push(20);
        lls.push(50);
        lls.push(80);
        lls.push(40);
        lls.push(60);
        lls.push(75);
        System.out.println("Element removed from LinkedList: "+lls.pop());
        System.out.println("Element removed from LinkedList: "+lls.pop());
        lls.push(10);
        System.out.println("Element removed from LinkedList: "+lls.pop());
        printList(lls.head);
    }
}

/**
 *
 * Exception to indicate that LinkedList is empty.
 */
class LinkedListEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public LinkedListEmptyException() {
        super();
    }

    public LinkedListEmptyException(String message) {
        super(message);
    }
}
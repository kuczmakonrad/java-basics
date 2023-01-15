package pl.kuczdev.__code_questions.q47_linkedList_singly_linked_list;

/*
In this post, we will see how to implement singly linked list in java.
It is one of the most used data structure. In singly linked list, Node has data and pointer to next node.
It does not have pointer to the previous node. Last node ‘s next points to null, so you can iterate over linked list by using this condition.
Node for linked list can be presented as below:
 */
class Node {
    public int data;
    public Node next;

    public void displayNodeData() {
        System.out.println("{ " + data + " } ");
    }
}

class SinglyLinkedList {
    private Node head;

    public boolean isEmpty() {
        return (head == null);
    }

    // used to insert a node at the start of linked list
    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    // used to delete node from start of linked list
    public Node deleteFirst() {
        Node temp = head;
        head = head.next;
        return temp;
    }

    // Use to delete node after particular node
    public void deleteAfter(Node after) {
        Node temp = head;
        while (temp.next != null && temp.data != after.data) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next = temp.next.next;
    }

    // used to insert a node at the start of linked list
    public void insertLast(int data) {
        Node current = head;
        while (current.next != null) {
            current = current.next; // we'll loop until current.next is null
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }

    // For printing Linked List
    public void printLinkedList() {
        System.out.println("Printing LinkedList (head --> last) ");
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println();
    }
}

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertFirst(5);
        sll.insertFirst(6);
        sll.insertFirst(7);
        sll.insertFirst(1);
        sll.insertLast(2);

        sll.printLinkedList();          // NodeList will be: 1 -> 7 -> 6 -> 5 -> 2

        Node node = new Node();
        node.data = 1;
        sll.deleteAfter(node);

        sll.printLinkedList();          // After deleting node after 1 (it will be 7) list will be: 1 -> 6 -> 5 -> 2
    }
}

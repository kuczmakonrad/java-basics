package pl.kuczdev.__code_questions.q48_linkedList_reverse_linked_list;

import org.w3c.dom.Node;

/*
Base case: Base case for this would be either node is null or node.next is null
For recursive solution, replace reverseLinkedList of above program to below function

Now lets understand logic for above recursive program.
5->6->7->1->2
Above function will terminate when last node(2)‘s next will be null.so while returning when you reach at node with value 1,
If you closely observe node.next.next=node is actually setting 2->1(i.e. reversing the link between node with value 1 and 2)
and node.next=nullis removing link 1->2. So in each iteration, you are reversing link between two nodes.
 */
class LinkedList {
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

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    // Reverse linkedlist using this function
    public static Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node remaining = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return remaining;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Creating a linked list
        Node head = new Node(5);

        list.addToTheLast(head);
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));

        list.printList(head);
        //Reversing LinkedList
        Node reverseHead = reverseLinkedList(head);
        System.out.println("After reversing");
        list.printList(reverseHead);
    }
}
package pl.kuczdev.__code_questions.q49_linkedList_how_to_find_middle_element;

/*
Assumption:
I am not using java LinkedList API here. If you use that API, you can directly find size of linkedlist using size() function and then locate length/2.
One of the algo for this would be:
Traverse the list and find the length of list
After finding length, again traverse the list and locate n/2 element from head of linkedlist.
Time complexity=time for finding length of list + time for locating middle element=o(n)+o(n) =o(n)
Space complexity= o(1).

Efficient approach:
Above approach will take two traversal but we can find middle element in one traversal also using following algo:

Use two pointer fastptr and slowptr and initialize both to head of linkedlist
Move fastptr by two nodes and slowptr by one node in each iteration.
When fastptr reaches end of nodes, the slowptr pointer will be  pointing to middle element.
*/

public class LinkedListMiddleElementWithoutOriginalLinkedList {
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

    // This function will find middle element in linkedlist
    public Node findMiddleNode(Node head) {
        Node slowPointer;
        Node fastPointer;
        slowPointer = fastPointer = head;

        while(fastPointer != null) {
            fastPointer = fastPointer.next;     // moving fast pointer first
            if(fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next; // moving slow pointer first
                fastPointer = fastPointer.next; // moving fast pointer second
            }
        }
        // when last pointer finished - slow pointer is in the middle and pointing on middleElement

        return slowPointer;

    }

    public static void main(String[] args) {
        LinkedListMiddleElementWithoutOriginalLinkedList list = new LinkedListMiddleElementWithoutOriginalLinkedList();
        // Creating a linked list
        Node head=new Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));

        list.printList();
        // finding middle element
        Node middle= list.findMiddleNode(head);
        System.out.println("Middle node will be: "+ middle.value);
    }
}


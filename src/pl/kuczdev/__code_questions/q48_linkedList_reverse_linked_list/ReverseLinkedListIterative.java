package pl.kuczdev.__code_questions.q48_linkedList_reverse_linked_list;

// You need to write iterative and recursive solution to reverse linked list.
/*
iterative logic:
1. Have three nodes i.e previousNode,currentNode and nextNode
2. When currentNode is starting node, then previousNode will be null
3. Assign currentNode.next to previousNode to reverse the link.
4. In each iteration move currentNode and previousNode by 1 node.
 */

class LinkedListNew {
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
    public static Node reverseLinkedList(Node currentNode) {
        // For first node, previousNode will be null
        Node previousNode = null;
        Node nextNode;
        while(currentNode != null)
        {
            nextNode = currentNode.next;
            // reversing the link
            currentNode.next = previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static void main(String[] args) {
        LinkedListNew list = new LinkedListNew();
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
package pl.kuczdev.__code_questions.q52_linkedList_is_palindrome;
/*
Algorythm:
    1. Find middle element of linked list using slow and fast pointer method .
    2. Reverse second part of linked list
    3. Compare first and second part of linked list if it matches then linked list is palindrome.
Time complexity : O(n)
Space complexity : O(1)

 */
public class LinkedListIsPalindromeByBlog {
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
    public static Node findMiddleNode(Node head) {
        // step 1
        Node slowPointer, fastPointer;
        slowPointer = fastPointer = head;

        while(fastPointer !=null) {
            fastPointer = fastPointer.next;
            if(fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }

        return slowPointer;
    }

    // Function to check if linked list is palindrome or not
    public static boolean checkPalindrome (Node head) {
        Node middleNode = findMiddleNode(head);       // Find middle node using slow and fast pointer
        Node secondHead = middleNode.next;            // we got head of second part
        middleNode.next = null;                       // It is end of first part of linked list
        Node reverseSecondHead = reverseLinkedList(secondHead); // get reversed linked list for second part

        while(head!=null && reverseSecondHead!=null) {
            if(head.value==reverseSecondHead.value) {
                head=head.next;
                reverseSecondHead=reverseSecondHead.next;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static Node reverseLinkedList(Node currentNode) {
        // For first node, previousNode will be null
        Node previousNode=null;
        Node nextNode;
        while(currentNode != null) {
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
        LinkedListIsPalindromeByBlog list = new LinkedListIsPalindromeByBlog();
        // Creating a linked list
        Node head=new Node(1);
        list.addToTheLast(head);
        list.addToTheLast(new Node(2));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));
        list.addToTheLast(new Node(1));

        list.printList();

        System.out.println("Linked list palidrome: "+checkPalindrome(head));
    }
}
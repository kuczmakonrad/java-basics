package pl.kuczdev.__code_questions.q51_linkedList_how_to_find_detect_loop_if_found_find_first_node;
/*
Algorythm:
    1. Find meeting point of slowPointer and fastPointer.
    2. set slowPointer to head node of linkedlist.
    3. Move slowPointer and fastPointer both by one node.
    4. The node at which slowPointer and fastPointer meets, will be starting node of loop.

https://java2blog.com/find-start-node-of-loop-in-linkedlist/
You must be wondering how above approach will work.

    Distance travelled by slowPointer= A+B
    Distance travelled by fastPointer= (A+B+C) + B =A+2B+C
    Let speed of slow pointer be X , so speed of fast pointer will be 2*X
    As per simple distance speed, time relation:
    (A+B)/X=A+2B+C/2*X
    2*(A+B)=A+2B+C
    2A+2B=A+2B+C
    A=C
    Hence if we set slowPointer to head and move both slowPointer and fastpointer by one node, they will meet at start node of loop.
 */
public class LinkedListFindStartNodeOfLoop {
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

    public Node findStartNodeOfTheLoop() {
        Node fastPtr = head;
        Node slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
            {
                loopExists = true;
                break;
            }

        }
        if(loopExists) {
            slowPtr = head;

            while(slowPtr!=fastPtr) {
                slowPtr=slowPtr.next;
                fastPtr=fastPtr.next;
            }
        } else {
            System.out.println("Loop does not exists");
            slowPtr = null;
        }
        return slowPtr;
    }

    public static void main(String[] args) {
        LinkedListFindStartNodeOfLoop list = new LinkedListFindStartNodeOfLoop();
        // Creating a linked list
        Node loopNode = new Node(7);
        list.addToTheLast(new Node(5));
        list.addToTheLast(new Node(6));
        list.addToTheLast(loopNode);
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));

        list.printList();
        list.addToTheLast(loopNode);

        Node startNode=list.findStartNodeOfTheLoop();
        if(startNode!=null)
            System.out.println("start Node of loop is "+ startNode.value);
    }
}

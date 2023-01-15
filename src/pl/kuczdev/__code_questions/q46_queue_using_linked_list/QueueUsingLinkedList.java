package pl.kuczdev.__code_questions.q46_queue_using_linked_list;
/*
Queue is abstract data type which demonstrates First in first out (FIFO) behaviour. We will implement same behaviour using Array.
Although java provides implementation for  all abstract data types such as Stack , Queue and LinkedList
but it is always good idea to understand basic data structures and implement them yourself.

Please note that LinkedList implementation of Queue is dynamic in nature.
There are two most important operations of Queue:
enqueue : It is operation when we insert element into the queue.
dequeue : It is operation when we remove element from the queue.
 */
public class QueueUsingLinkedList {
    private Node front,rear;
    private int currentSize; // numbers of items

    // class to define linked node
    private class Node {
        int data;
        Node next;
    }

    //Zero argument constructor
    public QueueUsingLinkedList() {
        front = null;
        rear = null;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return (currentSize == 0);
    }

    //Remove item from the beginning of the list.
    public int dequeue() {
        int data = front.data;
        front = front.next;
        if (isEmpty())
        {
            rear = null;
        }
        currentSize--;
        System.out.println(data+ " removed from the queue");
        return data;
    }

    //Add data to the end of the list.
    public void enqueue(int data) {
        Node oldRear = rear;
        rear = new Node();
        rear.data = data;
        rear.next = null;
        if (isEmpty()) {
            front = rear;
        } else {
            oldRear.next = rear;
        }
        currentSize++;
        System.out.println(data + " added to the queue");
    }

    public static void main(String a[]){
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(99);
        queue.enqueue(56);
        queue.dequeue();
        queue.enqueue(43);
        queue.dequeue();
        queue.enqueue(89);
        queue.enqueue(77);
        queue.dequeue();
        queue.enqueue(32);
        queue.enqueue(232);
    }
}
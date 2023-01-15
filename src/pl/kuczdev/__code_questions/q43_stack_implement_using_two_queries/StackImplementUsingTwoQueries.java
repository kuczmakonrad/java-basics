package pl.kuczdev.__code_questions.q43_stack_implement_using_two_queries;

import java.util.LinkedList;
import java.util.Queue;

/*
In this program, we will see how to implement stack using Linked List in java.
Stack is abstract data type which demonstrates Last in first out (LIFO) behavior. We will implement same behavior using two queue.
There are two most important operations of Stack:
Lets say you have two queues : queue1 , queue2

Push:
    If queue1 is empty, add elements to queue1.
    If queue1 is not empty, add all elements of queue1 to queue2 , add current element to queue1 and copy all elements of queue2 to queue1.

Pop:
    Simply remove element from queue1.

 */
public class StackImplementUsingTwoQueries {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public StackImplementUsingTwoQueries() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    // Remove value from the beginning of the list for demonstrating behaviour of stack
    public void push(int i){
        if(queue1.size()==0) {
            queue1.add(i);
        } else {
            int sizeOfQueue1 = queue1.size();

            // Copy elements of Queue1 to Queue2
            for (int j = 0; j < sizeOfQueue1; j++) {
                queue2.add(queue1.remove());
            }

            queue1.add(i);

            // Copy elements for Queue2 to Queue1
            for(int k = 0; k < sizeOfQueue1; k++)
                queue1.add(queue2.remove());
        }
    }

    public int pop() {
        if(queue1.size() == 0)
            throw new QueueEmptyException("Underflow Exception");
        return queue1.remove();
    }

    public static void main(String[] args) {
        StackImplementUsingTwoQueries stack = new StackImplementUsingTwoQueries();
        stack.push(20);
        stack.push(40);
        stack.push(70);
        stack.push(50);
        stack.push(90);
        stack.push(110);
        stack.push(30);
        System.out.println("Removed element : "+ stack.pop());
        stack.push(170);
        System.out.println("Removed element : "+ stack.pop());
    }
}


/**
 * Exception to indicate that Queue is empty.
 */

class QueueEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
package pl.kuczdev.__code_questions.q41_stack_implement_using_array;
/*

Stack is abstract data type which depicts Last in first out (LIFO) behavior.
Although java provides implementation for all abstract data types such as Stack,Queue and LinkedList,
but it is always good idea to understand basic data structures and implement them yourself.
Please note that Array implementation of Stack is not dynamic in nature. You can implement Stack through linked list for dynamic behavior.

Stack supports following basic operations:
    * push: Push element to the top of the Stack. This operation will increase size of stack by 1.
    * pop: Remove element from the top of the Stack and returns the deleleted Object. This operation will decrease size of stack by 1.
    * isEmpty: Check if Stack is empty or not.
    * isFull: Check if Stack is full or not.
    * peek: Returns top element from the stack without removing it.

As you can see we have pushed 40 in last, so it is popped first as Stack is of Last In First Out(LIFO) nature.
 */
public class StackImplementUsingArray {
    int size;
    int arr[];
    int top;

    public StackImplementUsingArray(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int element) {
        if (!isFull()) {
            top++;
            arr[top] = element;
            System.out.println("Pushed element: " + element);
        } else {
            System.out.println("Stack is full!");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            System.out.println("Popped element:" + arr[returnedTop]);
            return arr[returnedTop];
        } else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }

    public int peek() {
        if(!isEmpty()) {
            return arr[top];
        } else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

    public static void main(String[] args) {
        StackImplementUsingArray stackCustom = new StackImplementUsingArray(10);
        stackCustom.pop();
        System.out.println("================= push 4 elements");
        stackCustom.push(10);
        stackCustom.push(30);
        stackCustom.push(50);
        stackCustom.push(40);
        // {40,50,30,10}
        System.out.println("================= pop 3 times");
        stackCustom.pop();
        stackCustom.pop();
        stackCustom.pop();
        System.out.println("=================");
    }
}

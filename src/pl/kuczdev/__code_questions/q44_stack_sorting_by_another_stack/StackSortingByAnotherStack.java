package pl.kuczdev.__code_questions.q44_stack_sorting_by_another_stack;
/*
Problem:
Given a Stack, you need to sort it with the help of temporary stack.

Solution:
    1. Let’s say, you have two stacks, stack and tempStack.
    2. Pop an element currentData from stack and compare it with head of tempStack.
    3. If currentData it greater, push it to tempStack.
    4. If currentData is lesser than  head of tempStack, pop an element from tempStack and push it to stack until you get the element which is greater than currentData
    5. In the end, tempStack will be sorted stack.
*/

public class StackSortingByAnotherStack {
    int size;
    int arr[];
    int top;

    public StackSortingByAnotherStack (int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int pushedElement) {
        if (!isFull()) {
            top++;
            arr[top] = pushedElement;
        } else {
            System.out.println("Stack is full!");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            return arr[returnedTop];
        } else {
            System.out.println("Stack is empty!");
            return -1;
        }
    }

    public int peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

    public static void main(String[] args) {
        StackSortingByAnotherStack stackCustom = new StackSortingByAnotherStack(10);
        System.out.println("=================");
        stackCustom.push(10);
        stackCustom.push(30);
        stackCustom.push(50);
        stackCustom.push(40);
        stackCustom.printStack(stackCustom);
        StackSortingByAnotherStack sortedStack=sortStack(stackCustom);
        System.out.println("=================");
        System.out.println("After Sorting :");
        System.out.println("=================");
        sortedStack.printStack(sortedStack);

    }

    // Sort a stack using another stack
    public static StackSortingByAnotherStack sortStack(StackSortingByAnotherStack stack) {
        StackSortingByAnotherStack tempStack = new StackSortingByAnotherStack(10);
        while (!stack.isEmpty()) {
            int currentData=stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > currentData) {
                stack.push(tempStack.pop());
            }
            tempStack.push(currentData);
        }
        return tempStack;
    }

    public void printStack(StackSortingByAnotherStack stack) {
        if(top>=0) {
            System.out.println("Elements of stacks are:");
            for (int i = 0; i <= top; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
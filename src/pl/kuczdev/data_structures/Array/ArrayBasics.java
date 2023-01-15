package pl.kuczdev.data_structures.Array;

import java.util.Arrays;

/*
Array is linear data structure which stores fixed number of similar elements.
Array can store primitive data types as well as object but it should be of same kind.
This is one of most used data structures in java.

Advantages of array:
    * You can randomly access array elements using index.
    * It can represent multiple elements of same type with single name.
    * You can implement various data strucures such as LinkedList, Stack and Queue using Array.
Disadvantages of array:
    * You need to know number of elements in advance.
    * You can not modify array once its size is defined.
    * Insertion and deletion are quite costly operation in array as you need to shift elements.

There are many java tricky interview programs that can be asked in interview.
You should practice these java interview programs on array.
You can check a lot of programs in:
    pl.kuczdev.__code_questions.
    mainly between q10-q40 (30 code questions)

 */
public class ArrayBasics {
    public static void main(String[] args) {
        // Declare and initialize array in java
        int[] arr = new int[5];
        int[] arr2 = new int[] {1,2,3};
        int[] arr3 = {1,2,3};

        String arr4[] = new String[20];
        String arr5[] = {"ABC", "GHJ"};

        System.out.println("Array elements are:");        // Iterate over array
        for (int i=0; i < arr5.length;i++) {
            System.out.println(arr5[i]);
        }

        System.out.println("====================");
        System.out.println("Printing array elements using Arrays.toString():");
        System.out.println(Arrays.toString(arr5));        // You can also use Arrays.toString() to print an array
    }

}

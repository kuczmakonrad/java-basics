package pl.kuczdev.__code_questions.q29_arrays_count_1s_in_sorted_binary_array;

import java.util.Scanner;

/*
We can use divide and conquer approach, and move recursively at every step dividing the array into two subarrays virtually by keeping our start
and end pointers.
    1. If the element at end pointer of a subarray is zero this means that all the elements in that array would be zeroes and we know the array
        is already sorted.
    2. What if the first element that is the value at start pointer of the array? this means that all the elements in that subarray are ones again
        keeping in mind that array is sorted.

Now let’s discuss the time complexity.
At every call we are basically dividing the number of elements to work upon into two halves.
Initially we had N elements, then N/2, then N/4 and so on until we have one element left to work with.

if we denote T(n) for the time taken to process n elements.
Mathematically, we can write the equations as:
        T(n) = T(n/2) + T(n/2)
        T(n/2) = T(n/4) + T(n/4)
        .
        .
        .
        T(2) = T(1) + T(1)

Say we have x such equations and as we move up in equations, number of elements are getting doubled, so eventually,
    n = 2^x
taking log on both sides,
    x = log(n) {to the base 2}
Hence the complexity of our algorithm comes out to be O(log(n)).
 */
public class CountNum1InArrayInSortedArrayEffective {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.print("arr[]: {");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }

        System.out.println(" }");

        System.out.println("Number of 1 in array :"+solveEfficient(0, arr.length-1, arr));

    }

    public static int solveEfficient(int start, int end, int[] arr) {
        if (arr[start] == 1) {
            // start elem is one, hence all other elements will be one in virtual subarr.
            return end - start + 1;
        }

        if (arr[end] == 0) {
            // end elem is zero this means, all previous elements of subarr will be zeroes.
            return 0;
        }

        int mid = (start + end) / 2;
        int leftResult = solveEfficient(start, mid, arr);
        int rightResult = solveEfficient(mid + 1, end, arr);
        // divide the array into two virtual subHalves
        return leftResult + rightResult;

    }
}

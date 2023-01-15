package pl.kuczdev.__code_questions.q25_arrays_frequency_elements_in_sorted_array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
Lets first Discuss the basic divide and conquer strategy to solve this problem.
we divide the array into two halves every time our function is called splitting our problem
into half every time giving rise to a worst time complexity of O(log(n)).

Our array is not actually divided into halves, but we keep two pointers start and end representing some portion of array to work with
and this is how our array is virtually split.

We know that our array is already sorted. So we can conclude that,
        * if the elements at start pointer and end pointer are equal to the element whose frequency is to be calculated,
        this means that whole virtual array contains that element only and hence we directly add (end-start+1) to our frequency count.
        * If this is not the case,
        we recur for the two halves of the array and in post order we will add the calls of these two result to make our final frequency count result.

Now, This whole algorithm was for finding the frequency of one element in the array.
For finding the frequency of every element this function needs to be called every time.
Hence the overall worst time complexity for solving this problem with this algorithm will be O(n*log(n)).
 */

public class FreqOfEachElemsByDivideAndWinMethod {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("How much elements do You want in array: ");
        int[] arr = new int[scn.nextInt()];

        System.out.println("Put numbers and click enter: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(arr));

        HashSet<Integer> processed = new HashSet();
        for (int val : arr) {
            if (!processed.contains(val)) {
                System.out.println("Frequency of " + val + " is: " + solveRecursive(0, arr.length - 1, arr, val));
                processed.add(val);
            }
        }
    }
    public static int solveRecursive(int start, int end, int[] arr, int element) {
        // if start is greater than n, we need to return because this represent a subarray of negative size.
        if (start > end) {
            return 0;
        }
        // this means that the size of the virtual subarray is one, and it has only single element.
        if (start == end) {
            if (arr[start] == element && arr[end] == element) {
                return 1;
            } else {
                return 0;
            }
        }

        /* if the virtual subarray is of size greater than one, and the elements at start and at the end are equal,
         * this means that whole array consists of that element only, as the array we are working on is already sorted.*/
        if (arr[start] == element && arr[end] == element) {
            return (end - start + 1);
        }

        int mid = (start + end) / 2;
        /* call for left side virtual subarray */
        int leftResult = solveRecursive(start, mid, arr, element);

        /* call for right side virtual subarray.*/
        int rightResult = solveRecursive(mid + 1, end, arr, element);

        /* our result will be calculated in postorder,
         * which will be left side result
         * plus the right side sum.*/
        return leftResult + rightResult;
    }
}

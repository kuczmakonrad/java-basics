package pl.kuczdev.__code_questions.q27_arrays_find_peak_elements_in_array;

import java.util.Scanner;

/*
Problem:
Given an array of integers. find the peak element in the array.
Peak Element is the element of the array which is GREATER THAN / EQUAL TO its neighbours, that is, for an element at i th index,
the neighbour elements at index i-1 & i+1 must be greater than equal to element at i th position.

An array can have several peak elements, we need to output any one of them.

Solution:
The basic approach to this problem would be iterate through the whole array and at every i th element check the condition arr[i-1] = arr[i+1].
    For an array with equal numbers, every element will be peak element.
    For corner elements the conditions gets slightly tweaked as they will have only one neighbour, that is,
        for extreme left element we just need to check if arr[i+1] <= arr[i].
        for extreme right element we just need to check arr[i-1] <= arr[i].

The worst time complexity of this approach would be O(n).

Efficient Approach:
    We can use a Divide and conquer approach for the same which uses an algorithm similar to Binary search
    where a condition is checked with the middle element and depending on the result we search for our answer in one of the halves of the initial array.
    As the number of elements gets half on every call, this will have the worst time complexity of O(log(n)).

Algorithm:
    We compare middle element of the array with its neighbours and if it is greater than or equal to its neighbours.
    If the middle element is greater than or equal to its neighbours, we return it.
    If the element is smaller than its left neighbour then it is sure that the peak element lies in left.

WHY?
Consider an Array,
    int[] arr = {a1, a2, a3, a4, a5, a6, a7};

There arise 2 cases when left neighbour(a3) is greater than middle element(a4) i.e. a3 > a4:
    Case-1: if the left neighbour(a3) is corner, then this is our peak element.
    Case-2: if left element is not the corner element.Here again 2 possibilities arise, that is
        1. if a2 > a3, then this becomes the same recursive subproblem which we discussed above and its result will eventually be calculated recursively.
        2. if a2 < a3, then again a3 is our peak element because, a3 > a2  &  a3 > a4, i.e. a3 is greater than or equal to its neighbours.

The same procedure is followed the case when right neighbour (a5) is greater than middle element.
 */
public class PeakElementsInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int peakIndex = solve(0, arr.length - 1, arr);

        System.out.print("arr[]: {");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }

        System.out.println(" }");
        System.out.println("Peak element is : " + arr[peakIndex] + " found at index " + peakIndex);
    }

    public static int solve(int start, int end, int[] arr) {
        int mid = (start + end) / 2;        // finding mid for dividing the array into two parts

        // if the mid element is not the corner element and it is greater than or equal to its neighbours
        if ((mid > 0 && mid < arr.length - 1) && (arr[mid] >= arr[mid + 1] && arr[mid] >= arr[mid - 1])) {
            return mid;
        } else if (mid == 0 && mid!= arr.length-1 && arr[mid] >= arr[mid + 1]) { // if the mid element is left corner element and it is greater than or equal to its right neighbour.
            return mid;
        } else if (mid == arr.length - 1 && mid!= 0 && arr[mid - 1] <= arr[mid]) { // if the mid element is right corner element and it is greater than or equalto its left neighbour.
            return mid;
        } else if (mid != 0 && arr[mid - 1] > arr[mid]) { // if mid element is smaller than its left neighbour, then peak element will be in left side for sure.
            return solve(start, mid - 1, arr);
        } else {
            if(mid + 1 <= arr.length-1) {
                return solve(mid + 1, end, arr);
            }
        }
        // in case the array has only one element then than is the peak element
        return 0;
    }

}
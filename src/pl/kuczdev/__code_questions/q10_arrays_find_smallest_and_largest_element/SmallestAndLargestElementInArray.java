package pl.kuczdev.__code_questions.q10_arrays_find_smallest_and_largest_element;

import java.util.Arrays;

/*
You are given an integer array containing 1 to n but one of the number from 1 to n in the array is missing.
You need to provide an optimum solution to find the missing number. Number can not be repeated in the arry.

Initialise two variable largest and smallest with arr[0]
Iterate over array
If current element is greater than largest, then assign current element to largest.
If current element is smaller than smallest, then assign current element to smallest.
You will get smallest and largest element in the end.
 */
public class SmallestAndLargestElementInArray {
    public static void main(String[] args) {

        System.out.println("First method (mine):");
        long t1 = System.currentTimeMillis();
        int[] arr1 = {7,5,6,1,4,2};
        System.out.println("For array = {7,5,6,1,4,2} biggest number is 7 and lowest is 1.");
        System.out.println("BIGGEST NUMBER = " + getBiggestElementFromArray(arr1));
        System.out.println("SMALLEST NUMBER = " + getSmallestElementFromArray(arr1));

        int[] arr2 = {5,3,1,2};
        System.out.println("For array = {5,3,1,2} biggest number is 5 and lowest is 1.");
        System.out.println("BIGGEST NUMBER = " + getBiggestElementFromArray(arr2));
        System.out.println("SMALLEST NUMBER = " + getSmallestElementFromArray(arr2));

        int[] arr3 = {15, 6, 3, 36, 63, 45, 12, 61, 22, 11, 83, 2, 99, 64, 67, 30, 97, 11, 75, 20, 25, 50, 43, 47, 13, 25, 54, 22, 57, 44, 77, 96, 26, 90, 79, 40, 75, 31, 88, 37, 99, 63, 30, 80, 46, 99, 86, 94, 69, 49, 93, 23, 27, 70, 100, 89, 73, 71, 3, 83, 94, 7, 95, 81, 81, 52, 6, 84, 24, 76, 59, 32, 71, 27, 40, 30, 67, 68, 63, 80, 55, 81, 3, 24, 56, 63, 93, 9, 95, 86, 54, 48, 35, 25, 57, 48, 54, 72, 24};
        System.out.println("For long array biggest number is 100 and lowest is 2.");
        System.out.println("BIGGEST NUMBER = " + getBiggestElementFromArray(arr3));
        System.out.println("SMALLEST NUMBER = " + getSmallestElementFromArray(arr3));

        long t2 = System.currentTimeMillis();
        System.out.println("First method time (mine)" + (t2-t1));

        System.out.println("SECOND method (BLOG):");
        long t3 = System.currentTimeMillis();
        int[] arr4 = {7,5,6,1,4,2};
        System.out.println("For array = {7,5,6,1,4,2} biggest number is 7 and lowest is 1.");
        System.out.println("BIGGEST NUMBER = " + getBiggestElementFromArrayFromBlog(arr4));
        System.out.println("SMALLEST NUMBER = " + getSmallestElementFromArrayFromBlog(arr4));

        int[] arr5 = {5,3,1,2};
        System.out.println("For array = {5,3,1,2} biggest number is 5 and lowest is 1.");
        System.out.println("BIGGEST NUMBER = " + getBiggestElementFromArrayFromBlog(arr5));
        System.out.println("SMALLEST NUMBER = " + getSmallestElementFromArrayFromBlog(arr5));

        int[] arr6 = {15, 6, 3, 36, 63, 45, 12, 61, 22, 11, 83, 2, 99, 64, 67, 30, 97, 11, 75, 20, 25, 50, 43, 47, 13, 25, 54, 22, 57, 44, 77, 96, 26, 90, 79, 40, 75, 31, 88, 37, 99, 63, 30, 80, 46, 99, 86, 94, 69, 49, 93, 23, 27, 70, 100, 89, 73, 71, 3, 83, 94, 7, 95, 81, 81, 52, 6, 84, 24, 76, 59, 32, 71, 27, 40, 30, 67, 68, 63, 80, 55, 81, 3, 24, 56, 63, 93, 9, 95, 86, 54, 48, 35, 25, 57, 48, 54, 72, 24};
        System.out.println("For long array biggest number is 100 and lowest is 2.");
        System.out.println("BIGGEST NUMBER = " + getBiggestElementFromArrayFromBlog(arr6));
        System.out.println("SMALLEST NUMBER = " + getSmallestElementFromArrayFromBlog(arr6));

        long t4 = System.currentTimeMillis();
        System.out.println("Second method time (BLOG)" + (t4-t3));
    }

    private static int getSmallestElementFromArray(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }

    private static int getBiggestElementFromArray(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1];
    }

    // second way from blog
    private static int getBiggestElementFromArrayFromBlog(int[] arr) {
        int biggest = arr[0];
        for(int i=1; i< arr.length; i++) {
            if(arr[i] > biggest) biggest = arr[i];
        }
        return biggest;
    }

    // second way from blog
    private static int getSmallestElementFromArrayFromBlog(int[] arr) {
        int smallest = arr[0];
        for(int i=1; i< arr.length; i++) {
            if(arr[i] < smallest) smallest = arr[i];
        }
        return smallest;
    }
}

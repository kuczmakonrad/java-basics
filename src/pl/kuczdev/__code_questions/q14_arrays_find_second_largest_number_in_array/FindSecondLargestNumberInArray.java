package pl.kuczdev.__code_questions.q14_arrays_find_second_largest_number_in_array;

import java.util.Arrays;

public class FindSecondLargestNumberInArray {
    public static void main(String[] args) {
        System.out.println("First Method from blog:");
        long t1 = System.nanoTime();
        int[] test = {7,5,6,1,4,2};
        System.out.println("Second largest number in array [7,5,6,1,4,2] will be 6. RESULT IS = " + findSecondLargestNumberInArrayFromBlog(test));

        int[] test2 = {7,5,6,1,4,2,99,100};
        System.out.println("Second largest number in array [7,5,6,1,4,2,99,100] will be 6. RESULT IS = " + findSecondLargestNumberInArrayFromBlog(test2));

        int[] test3 = {0,0,0};
        System.out.println("Second largest number in array [0,0,0] will be 0. RESULT IS = " + findSecondLargestNumberInArrayFromBlog(test3));

        int[] test4 = {3,2,1};
        System.out.println("Second largest number in array [3,2,1] will be 0. RESULT IS = " + findSecondLargestNumberInArrayFromBlog(test4));

        int[] test10 = {7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100};
        System.out.println("Second largest number in big array will be 99. RESULT IS = " + findSecondLargestNumberInArrayFromBlog(test10));

        long t2 = System.nanoTime();
        System.out.println("TIME FIRST METHOD: " + (t2-t1));


        System.out.println("Second Method:");
        long t3 = System.nanoTime();
        int[] test5 = {7,5,6,1,4,2};
        System.out.println("Second largest number in array [7,5,6,1,4,2] will be 6. RESULT IS = " + findSecondLargestNumberInArray(test5));

        int[] test6 = {7,5,6,1,4,2,99,100};
        System.out.println("Second largest number in array [7,5,6,1,4,2,99,100] will be 6. RESULT IS = " + findSecondLargestNumberInArray(test6));

        int[] test7 = {0,0,0};
        System.out.println("Second largest number in array [0,0,0] will be 0. RESULT IS = " + findSecondLargestNumberInArray(test7));

        int[] test8 = {3,2,1};
        System.out.println("Second largest number in array [3,2,1] will be 0. RESULT IS = " + findSecondLargestNumberInArray(test8));

        int[] test9 = {7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100,7,5,6,1,4,2,99,100};
        System.out.println("Second largest number in big array will be 99. RESULT IS = " + findSecondLargestNumberInArray(test8));
        long t4 = System.nanoTime();
        System.out.println("TIME SECOND METHOD: " + (t4-t3));

    }

    private static int findSecondLargestNumberInArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Arrays.sort(arr);
        return arr[arr.length-2];
    }

    private static int findSecondLargestNumberInArrayFromBlog(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > highest) {
                secondHighest = highest;
                highest = arr[i];
            } else if (arr[i] > secondHighest && arr[i] != highest) {
                secondHighest = arr[i];
            }
        }

        return secondHighest;
    }
}

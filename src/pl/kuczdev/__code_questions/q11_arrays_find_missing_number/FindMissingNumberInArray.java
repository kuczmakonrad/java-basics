package pl.kuczdev.__code_questions.q11_arrays_find_missing_number;

import java.util.Arrays;

public class FindMissingNumberInArray {
    public static void main(String[] args) {
        System.out.println("First method (mine):");
        long t1 = System.currentTimeMillis();
        int[] arr1 = {7,5,6,1,4,2};
        System.out.println("For array = {7,5,6,1,4,2} missing number is 3. RESULT = " + getMissingNumberInArray(arr1));
        int[] arr2 = {5,3,1,2};
        System.out.println("For array = {5,3,1,2} missing number is 4. RESULT = " + getMissingNumberInArray(arr2));
        int[] arr3 = {9,7,5,6,1,4,3,2};
        System.out.println("For array = {9,7,5,6,1,4,3,2} missing number is 8. RESULT = " + getMissingNumberInArray(arr3));
        int[] arr4 = {1,2,3};
        System.out.println("For array = {1,2,3} missing number is -1 (because there is no missing number). RESULT = " + getMissingNumberInArray(arr4));
        int[] arr5 = {15, 6, 3, 36, 63, 45, 12, 61, 22, 11, 83, 2, 99, 64, 67, 30, 97, 11, 75, 20, 25, 50, 43, 47, 13, 25, 54, 22, 57, 44, 77, 96, 26, 90, 79, 40, 75, 31, 88, 37, 99, 63, 30, 80, 46, 99, 86, 94, 69, 49, 93, 23, 27, 70, 100, 89, 73, 71, 3, 83, 94, 7, 95, 81, 81, 52, 6, 84, 24, 76, 59, 32, 71, 27, 40, 30, 67, 68, 63, 80, 55, 81, 3, 24, 56, 63, 93, 9, 95, 86, 54, 48, 35, 25, 57, 48, 54, 72, 24};
        System.out.println("For this long array missing number is 88. RESULT = " + getMissingNumberInArray(arr5));
        long t2 = System.currentTimeMillis();
        System.out.println("First method time (mine)" + (t2-t1));


        System.out.println("\n\n\nSecond method (from blog):");
        long t3 = System.currentTimeMillis();
        int[] arr6 = {7,5,6,1,4,2};
        System.out.println("For array = {7,5,6,1,4,2} missing number is 3. RESULT = " + missingNumber(arr6));
        int[] arr7 = {5,3,1,2};
        System.out.println("For array = {5,3,1,2} missing number is 4. RESULT = " + missingNumber(arr7));
        int[] arr8 = {9,7,5,6,1,4,3,2};
        System.out.println("For array = {9,7,5,6,1,4,3,2} missing number is 8. RESULT = " + missingNumber(arr8));
        int[] arr9 = {1,2,3};
        System.out.println("For array = {1,2,3} missing number is -1 (because there is no missing number). RESULT = " + missingNumber(arr9));
        int[] arr10 = {15, 6, 3, 36, 63, 45, 12, 61, 22, 11, 83, 2, 99, 64, 67, 30, 97, 11, 75, 20, 25, 50, 43, 47, 13, 25, 54, 22, 57, 44, 77, 96, 26, 90, 79, 40, 75, 31, 88, 37, 99, 63, 30, 80, 46, 99, 86, 94, 69, 49, 93, 23, 27, 70, 100, 89, 73, 71, 3, 83, 94, 7, 95, 81, 81, 52, 6, 84, 24, 76, 59, 32, 71, 27, 40, 30, 67, 68, 63, 80, 55, 81, 3, 24, 56, 63, 93, 9, 95, 86, 54, 48, 35, 25, 57, 48, 54, 72, 24};
        System.out.println("For this long array missing number is 88. RESULT = " + missingNumber(arr10));
        long t4 = System.currentTimeMillis();
        System.out.println("First method time (mine)" + (t4-t3));

    }

    // mine version of function - function give back missing number if array (if there's not missing number result will be -1).
    private static int getMissingNumberInArray(int[] arr) {
        int counter = 1;
        Arrays.sort(arr);
        for (int i: arr) {
            if (i != counter) return counter;
            counter++;
        }
        return -1;
    }

    // second version of fuction - from blog
    /*
        You are given an integer array containing 1 to n but one of the number from 1 to n in the array is missing.
        You need to provide an optimum solution to find the missing number. Number can not be repeated in the arry.
    */
    public static int missingNumber(int[] arr) {
        int n = arr.length+1;
        int sum = n*(n+1)/2;
        int restSum = 0;
        for (int i = 0; i < arr.length; i++) {
            restSum += arr[i];
        }
        int missingNumber = sum-restSum;
        return missingNumber;
    }
}

package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

import java.util.Arrays;

public class q6_find_missing_number_in_array {
    public static void main(String[] args) {
        int[] arr = {1,2,8,4,3,5,6,7,9,10,12};
        System.out.println("Missing number in " + Arrays.toString(arr) + " is: " + findMissingNumberInIntArray(arr));
        System.out.println("Missing number in " + Arrays.toString(arr) + " is: " + missingNumber(arr));
    }

    private static int findMissingNumberInIntArray(int[] arr) {
        int counter = 1;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if (counter != arr[i]) return counter;
            counter++;
        }
        return -1;
    }

    public static int missingNumber(int[] arr) {
        int n = arr.length+1;
        int sum = n*(n+1)/2;
        int restSum = 0;
        for (int i = 0; i < arr.length; i++) {
            restSum+=arr[i];
        }
        int missingNumber = sum-restSum;
        return missingNumber;
    }
}

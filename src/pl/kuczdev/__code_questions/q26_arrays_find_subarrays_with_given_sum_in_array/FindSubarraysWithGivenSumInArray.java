package pl.kuczdev.__code_questions.q26_arrays_find_subarrays_with_given_sum_in_array;

import java.util.Scanner;

/*
Given an Array of non negative Integers and a number.
You need to print all the starting and ending indices of Subarrays having their sum equal to the given integer.

For Example:
    Input-
        int[] arr = {2, 3, 6, 4, 9, 0, 11};
        int num = 9
    Output-
        starting index : 1, Ending index : 2
        starting index : 5, Ending index : 5
        starting index : 5, Ending index : 6


Explanation:
    [3, 6] [9],
    [9,0] These all are the subarrays with their sum equal to 9.

Solution
Naive Method:
    The basic brute force approach to this problem would be generating all the subarrays of the given array,
    then loop through the generated subarray and calculate the sum
    and if this sum is equal to the given sum then printing this subarray as it is the part of our solution.
    Now we know, An Array with n elements has n*(n+1)/2 subarrays.
Now,
Total subarrays = subarrays starting with 0th idx + subarrays starting with 1st idx +
subarrays starting with 2nd idx + . . . + subarrays starting with nth idx
    Sn = n + (n-1) + (n-2) + (n-3) + ... + 1
    Sn = n(n+1)/2
There, generating all the subarrays and calculating the answer will cost us the worst time complexity of O(n(n+1)/2) which is of the order O(n^2).

 */
public class FindSubarraysWithGivenSumInArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("How much elements do You want in array: ");
        int[] arr = new int[scn.nextInt()];

        System.out.println("Which number is your target sum: ");
        int target = scn.nextInt();

        System.out.println("Put " + arr.length + " numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        solve(arr, target);
    }

    public static void solve(int[] arr, int target) {
        for(int start = 0; start < arr.length; start++) {
            int currSum = 0;     // initialize the sum of the current subarray to 0.

            for(int end = start; end < arr.length; end++) {
                currSum += arr[end];    // add every element of the current subarray to the current running sum.

                // print the starting and ending indices once we get subarray with given sum
                if(currSum == target) System.out.println("starting index : " + start + ", " + "Ending index : " + end);
            }
        }
    }
}

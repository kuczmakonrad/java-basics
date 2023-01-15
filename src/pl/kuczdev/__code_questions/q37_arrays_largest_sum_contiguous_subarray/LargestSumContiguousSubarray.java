package pl.kuczdev.__code_questions.q37_arrays_largest_sum_contiguous_subarray;
/*
From Wikipedia:
    In computer science,
    the Largest sum contiguous subarray is the task of finding the contiguous subarray within a one-dimensional array of numbers which has the largest sum.
    For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.

Solution 1: Time complexity : O(N^2).
    Use two loops and try each combination of array elements to find maximum sum.

Solution 2: Time complexity : O(N).
    Kadane ‘s algoritm

Solution 3:
    You can use dynamic programming to solve this problem.
    Lets say array be arr[] and maximum sum upto index i is maxSum(i)
    Logic which can be used for dynamic programming: maxSum(i) = Max of (maxSum(i-1) + a[i] , a[i]);
    So it can be define as
    Max sum at index i is maximum of (max sum upto i-1 + current element , current element)
 */
public class LargestSumContiguousSubarray {
    public static void main(String args[]) {
        int arr[] = { 1, 8, -3, -7, 2, 7, -1, -9 };
        LargestSumContiguousSubarray maxSum = new LargestSumContiguousSubarray();
        System.out.println("Largest sum continuous subarray is " + maxSum.dynamicProgramForMaxSubArray(arr));
    }

    public int dynamicProgramForMaxSubArray(int[] arr) {
        int result[] = new int[arr.length];
        result[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            result[i] = Math.max(result[i-1] + arr[i], arr[i]);
        }

        int maxSumArray = result[0];
        for (int j = 1; j < result.length; j++) {
             if(maxSumArray<result[j]) maxSumArray = result[j];
        }

        return maxSumArray;
    }
}

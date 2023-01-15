package pl.kuczdev.__code_questions.q38_arrays_find_contiguous_subarray_with_sum_to_given_value_in_array;
/*
Problem:
    Given an array of positive integer and given value X, find Contiguous sub array whose sum is equal to X.

For example:
    arr[]={14, 12, 70, 15, 99, 65, 21, 90};
    X =97.
    Sum found between index 1 to 3
    Elements are 12, 17 and 15

Solution 1: Time Complexity : O(N^2).
    Check all sub arrays and if current sum is equal to X, return. This will require two loops and if currentSum is greater than X tben try another sub array.

Solution 2: Time Complexity : O(N).
    Lets say array is arr[] and given sum is X.
        1. Iterate over array arr[].
        2. If currentSum is less than X then add current element to currentSum.
        3. If currentSum is greater than X , it means we need to remove starting elements to make currentSum less than X.
        4. If CurrentSum is equal to X, we got the continuous sub array, print it.
 */

public class FindContiguousSubarrayWithSumToGivenValueInArray {
    public static void main(String[] args) {
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};

        findSubArraySumEqualToX(arr, 33);

        System.out.println("n======================");

        findSubArraySumEqualToXOptimized(arr, 33);
    }

    static void findSubArraySumEqualToX(int arr[], int X) {
        int currentSum;
        for (int i = 0; i < arr.length; i++) {
            currentSum = arr[i];
            // try all subarrays starting with 'i'
            for (int j = i + 1; j <= arr.length; j++) {
                if (currentSum == X) {
                    int endIndexForContArray = j - 1;
                    System.out.println("Sum found between indexes " + i + " and " + endIndexForContArray);
                    for (int k = i; k <= endIndexForContArray; k++) {
                        System.out.print(arr[k]+" ");
                    }
                    return;
                }
                if (currentSum > X || j == arr.length)
                    break;

                currentSum = currentSum + arr[j];
            }
        }

        System.out.println("No subarray found");
        return;
    }

    public static void findSubArraySumEqualToXOptimized(int arr[], int X) {
        int currentSum = arr[0];
        int start = 0;

        for (int i = 1; i <= arr.length; i++) {
            // If currentSum is more than the sum, start removing starting elements unless you get currentSum is less than X
            while (currentSum > X && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }

            // If currentSum becomes equal to sum, then print the index
            if (currentSum == X) {
                int endIndexForContArray = i - 1;
                System.out.println("Sum found between indexes " + start + " and " + endIndexForContArray);
                System.out.println("Printing Array values : ");
                for (int j = start; j <= endIndexForContArray; j++) {
                    System.out.print(arr[j]+" ");
                }
                return;
            }

            // Add this element to currentSum
            if (i < arr.length) currentSum = currentSum + arr[i];
        }
    }
}

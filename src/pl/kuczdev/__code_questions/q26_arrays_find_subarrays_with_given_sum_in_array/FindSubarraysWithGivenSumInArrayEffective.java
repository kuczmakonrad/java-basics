package pl.kuczdev.__code_questions.q26_arrays_find_subarrays_with_given_sum_in_array;

import java.util.Scanner;

public class FindSubarraysWithGivenSumInArrayEffective {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        int target = scn.nextInt();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.print("arr[]: {");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+arr[i]);
        }

        System.out.println(" }");
        solveEfficient(arr, target);

    }

    public static void solveEfficient(int[] arr, int target) {
        int start = 0, end = 0;
        int currSum = 0;

        while (start < arr.length && end <= arr.length) {
            if (currSum == target) {
                /* as the currSum is equal to target sum, print the result with end as end-1.
                 because when we added the element at end we increased the pointer there only,
                 *  so now we need to subtract 1 because the subarray constituting that sum has
                 *  its last pointer one index where end is currently at.
                 */
                System.out.println("starting index : " + start + ", Ending index : " + (int) (end - 1));

                if (end <= arr.length - 1) {
                    currSum += arr[end];
                }
                end++;
            } else {
                // if the currSum becomes more than required, we keep on subtracting the start element until it is less than or equal to required target sum.
                if (currSum > target) {
                    currSum -= arr[start];
                    start++;
                } else {
                    // we add the last element to our currSum until our sum becomes greater than or equal to target sum.
                    if (end <= arr.length - 1) {
                        currSum += arr[end];
                    }
                    end++;
                }
            }
        }
    }
}
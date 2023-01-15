package pl.kuczdev.__code_questions.q17_arrays_find_pair_sum_closest_to_zero;

import java.util.Arrays;

/*
Problem:
    Given array of +ve and -ve integers ,we need to find a pair whose sum is closed to Zero in Array.

Example INPUT-OUTPUT:
    INPUT: array[]={1,3,-5,7,8,20,-40,6};
    OUTPUT: The pair whose sum is closest to zero: -5 and 6

Solution 1 (by brute force):
    You can check each and every pair of numbers and find minimum sum.

Solution 2:
    1. Sort the array.
    2. We will maintain two indexes one at beginning (l=0) and one at end (r=n-1).
    3. Iterate until l <  r.
    4. Calculate sum of arr[l] + arr[r].
    5. If abs (sum) < abs (minSum), then update the minimum sum and pair.
    6. If sum is less than 0, this means if we want to find sum close to 0, do r–-.
    7. If sum is greater than 0,this means if we want to find sum close to 0 , do l++.
 */
public class ArraysFindPairSumClosestToZero {
    public static void main(String[] args) {
        int array[] = {1, 3, -5, 7, 8, 20, -40, 6};
        findPairWithMinSumBruteForce(array);
        findPairWithMinSum(array);
    }

    public static void findPairWithMinSumBruteForce(int arr[]) {
        int index_i = 0;
        int index_j = 0;
        int closest = Integer.MAX_VALUE;

        if (arr.length < 2) {
            System.out.println("Too short array.");
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int sum = arr[i] + arr[j];
                    if (Math.abs(sum) < Math.abs(closest)) {
                        closest = sum;
                        index_i = i;
                        index_j = j;

                        if (closest == 0) {
                            break;
                        }
                    }
                }
            }

            System.out.println("The pair whose sum is closest to zero: ");
            System.out.println("It is sum of elements = " + arr[index_i] + " + " + arr[index_j]);
        }
    }

    public static void findPairWithMinSum ( int arr[]){
        // Sort the array, you can use any sorting algorithm to sort it
        Arrays.sort(arr);
        int sum = 0;
        int minimumSum = Integer.MAX_VALUE;
        int n = arr.length;

        if (n < 0)
            return;

        // left and right index variables
        int l = 0, r = n - 1;

        // variables to keep track of the left and right index pair for minimumSum
        int minLeft = l, minRight = n - 1;

        while (l < r) {
            sum = arr[l] + arr[r];

            /*If abs(sum) is less than min sum, we need to update sum and pair */
            if (Math.abs(sum) < Math.abs(minimumSum)) {
                minimumSum = sum;
                minLeft = l;
                minRight = r;
            }

            if (sum < 0)
                l++;
            else
                r--;
        }

        System.out.println(" The pair whose sum is minimun : "+arr[minLeft]+" + "+ arr[minRight]);
    }
}




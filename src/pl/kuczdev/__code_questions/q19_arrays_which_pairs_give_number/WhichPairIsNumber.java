package pl.kuczdev.__code_questions.q19_arrays_which_pairs_give_number;

import java.util.Arrays;
import java.util.HashMap;

public class WhichPairIsNumber {
    public static void main(String[] args) {
        int[] array = new int[]{-40, -5, 1, 3, 6, 7, 8, 20};

        System.out.println("First solution: ");
        findPairsWithSumGiveNumberBruteForce(array, 15);

        System.out.println("Second solution: ");
        findPairsWithSumGiveNumber(array, 15);

        System.out.println("Third solution: ");
        findPairsWithSumGiveNumberByHashing(array, 15);
    }
    // SOLUTION 1:
    // You can check each and every pair of numbers and find the sum equals to  X.
    private static void findPairsWithSumGiveNumberBruteForce(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == number) {
                    System.out.println("Pair of numbers: " + array[i] + " and " + array[j] + " gives " + number);
                }
            }
        }
    }

    // SOLUTION 2:
    // Time complexity : O(NLogN)
    /*
        Sort the array
        We will maintain two indexes one at beginning (l=0) and one at end (r=n-1)
        iterate until l <  r
        Check if arr[l] + arr[r] is equal to X
        if Yes, then print the pair and do l++, r–
        If arr[l] + arr[r] is less than X, this means if we want to find sum close to X, do r–
        If arr[l] + arr[r] is greater than X,this means if we want to find sum close to X , do l++
     */

    private static void findPairsWithSumGiveNumber(int[] array, int number) {
        int n = array.length;
        if (n < 2)
            return;
        Arrays.sort(array);
        System.out.println("The pair whose sum is equal to " + number + ": ");
        // left and right index variables
        int l = 0, r = n - 1;

        while (l < r) {
            int currentSum = array[l] + array[r];
            if (currentSum == number) {
                System.out.println("Pair of numbers: " + array[l] + " and " + array[r] + " gives " + number);
                l++;
                r--;
            } else if (array[l] + array[r] < number)
                l++;
            else
                r--;
        }
    }

    // SOLUTION 3:
    //Time complexity: O(NLogN) Space complexity : O(N)
    /*
        Put array element in HashMap with element as key and its index as value.
        Iterate over array arr[]
        Check for arr[i],  if X-arr[i] is present in HashMap.
        If yes, we have found the pair and print it.
     */
    private static void findPairsWithSumGiveNumberByHashing(int[] array, int number) {
        HashMap<Integer, Integer> elementIndexMap = new HashMap<Integer, Integer>();
        System.out.println("The pair whose sum is closest to 15 : ");
        for (int i = 0; i < array.length; i++) {
            elementIndexMap.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            // we have used elementIndexMap.get(X-arr[i])!=i to avoid using same
            // element twice
            if (elementIndexMap.get(number - array[i]) != null && elementIndexMap.get(number - array[i]) != i) //
            {
                System.out.println(array[i] + " " + (number - array[i]));
            }
        }

    }

}

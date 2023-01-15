package pl.kuczdev.__code_questions.q30_arrays_find_first_repeating_element_in_array;
/*
Solution
Simple solution will be use two loops.
Outer loop will iterate through loop and inner loop will check if element is repeated or not but time complexity of this solution will be o(n^2).

Another solution will be to create another array and sort it.
Pick element from original array and find the element in sorted array using binary search but time complexity of this solution will be o(n^logn).

Can we do better?
Yes, we can iterate from right to left and use HashSet to keep track fo minimumIndex
    1. Intialize minimumIndex with -1.
    2. Iterate over input array from right to left.
    3. If element is already present in Hashset, then update the minimumIndex else add element to the set.
    4. Once we are done with iteration, we will get minimumIndex in the end.
The time complexity of this solution is O(n) and space complexity is also O(n).
*/

import java.util.HashSet;

public class FindFirstRepeatingElementInArray {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,5,6,6,7,7};
        int min = getFirstRepeatingElementInArrayByMe(arr);
        if (min == -1) System.out.println("There's no repeat integers in array.");
        else System.out.println("First repeating element in array is: " + min);
    }

    private static int getFirstRepeatingElementInArrayByMe(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int minimumIndex = -1;

        for (int i = arr.length-1; i >= 0; i--) {
            if (hs.contains(arr[i])) {
                minimumIndex = arr[i];
            } else {
                hs.add(arr[i]);
            }
        }

        return minimumIndex;
    }
}

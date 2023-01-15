package pl.kuczdev.__code_questions.q25_arrays_frequency_elements_in_sorted_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/*
EFFICIENT APPROACH:
There is an iterative and even efficient approach also which solves the problem in single parse in linear time i.e. O(n).
What we can do is, we keep a frequency array and loop through the array, and every time we find any element we go to the frequency array
and add 1 to the previous frequency of that element in the frequency array.
After the loop ends, we are left with an array where at every index their frequency in the original array is present.
And also the biggest plus point along with its efficiency is, We don’t necessarily need the array to be sorted.

For eg :
    Consider an Array and its frequency array,
    int[] arr = {5,4,3,2,4,3,2,5,5};
    int[] freqArr = {0,0,0,0,0,0};
    the frequency array after the loop ends will look like,
    int[] freqArr = {0,0,2,2,1,3};
    In this frequency array, at every i th index, the frequency of  i in actual array is sitting.

By this time, we have already known the shortcomings of this approach,
Yes, this approach will not be effective when the input array contains negative numbers or numbers greater than 10^9.
Because we do not have any negative indices and an array of size 10^9 is not possible.
so for handling that, we need to use Hashmap where we store the element-frequency pair as the key-value pair in hashmap.
 */

public class FreqOfEachElemsByHashMap {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("How much elements do You want in array: ");
        int[] arr = new int[scn.nextInt()];

        System.out.println("Put numbers and click enter: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println("Array: " + Arrays.toString(arr));

        HashMap<Integer, Integer> freqMap = solveIterative(arr);

        for(int val : freqMap.keySet()) {
            System.out.println("Frequency of " + val + " is: " + freqMap.get(val));
        }
    }

    private static HashMap<Integer, Integer> solveIterative(int[] arr) {
        HashMap<Integer, Integer> res = new HashMap();

        for (int val: arr) {                                                        // iterate through the array for contributing +1 as a frequency of that element, every time it is encountered.
            res.computeIfPresent(val, (key, counter) -> counter = counter+1);       // if hashmap contains this element, so now its updated frequency will be its past frequency + 1.

            res.computeIfAbsent(val, (counter) -> counter = 1);                     // iterate through the array for contributing +1 as a frequency of that element, every time it is encountered.
        }
        System.out.println(res);
        return res;
    }
}

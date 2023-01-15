package pl.kuczdev.__fast_testing.__list__Java_Interview_Programs_for_Freshers;

import java.util.Arrays;

public class q5_search_a_number_in_sorted_array {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,3,3,4,5,6,7,8,8,10,11};
        int searchNumber = 3;
        Arrays.sort(arr);
        System.out.println("Number " + searchNumber + " is on index = " + searchNumberInSortedArray(arr, searchNumber));
        System.out.println("Number " + searchNumber + " is on index = " + searchNumberInSortedArrayOptimalized(arr, searchNumber));
        System.out.println("Number " + searchNumber + " is on index = " + binarySearch(arr, searchNumber)); // to jest poprawna wersja
    }

    private static int searchNumberInSortedArray(int[] arr, int searchNumber) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == searchNumber) return i;
        }
        return -1;
    }

    private static int searchNumberInSortedArrayOptimalized(int[] arr, int searchNumber) {
        // if array empty return -1
        if (arr.length == 0) return -1;

        // if number is higher than last element array return -1 (number is not in array)
        if (searchNumber > arr[arr.length-1]) return -1;

        // if one element - check numbers and return result
        if (arr.length == 1) {
            if (arr[0] == searchNumber) {
                return 0;
            } else {
                return -1;
            }
        }

        // divide and win
        int first = 0;
        int mid = arr.length/2;
        int last = arr.length-1;


        if (searchNumber < arr[mid]) {
            for (int i = first; i < mid-1; i++) {
                if (arr[i] == searchNumber) return i;
            }
        } else if (searchNumber > arr[mid]) {
            for (int i = mid+1; i <= last; i++) {
                if (arr[i] == searchNumber) return i;
            }
        } else {
            return mid;
        }

        // no number in arr
        return -1;
    }

    public static int binarySearch(int[] sortedArray, int elementToBeSearched) {
        int firstIndex = 0;
        int lastIndex = sortedArray.length - 1;

        while (firstIndex < lastIndex) {

            int mid = (firstIndex + lastIndex) / 2;  // Compute mid point.

            if (elementToBeSearched < sortedArray[mid]) {
                lastIndex = mid; // repeat search in first half.
            } else if (elementToBeSearched > sortedArray[mid]) {
                firstIndex = mid + 1;  // Repeat sortedArray in last half.
            } else {
                return mid;     // Found it. return position
            }
        }

        return -1;    // Failed to find element
    }

}